package net.nikk.beyondcultivation.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.item.ModItems;
import net.nikk.beyondcultivation.screen.handler.ApertureScreenHandler;
import net.nikk.beyondcultivation.util.IEntityDataSaver;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.awt.*;
import java.util.ArrayList;

public class ApertureScreen extends HandledScreen<ApertureScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("minecraft", "textures/gui/container/inventory.png");
    private final ArrayList<SpiritFoxEntity> entities = new ArrayList<>();
    private float essenceLevel = 0.5f;

    public ApertureScreen(ApertureScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
        loadEntitiesFromData();
    }

    private void loadEntitiesFromData() {
        if(this.client != null){
            if(this.client.player !=null){
                NbtCompound data = ((IEntityDataSaver) this.client.player).getPersistentData();
                NbtList list = data.getList("ApertureEntities", NbtElement.COMPOUND_TYPE);
                for (int i = 0; i < list.size(); i++) {
                    SpiritFoxEntity fox = new SpiritFoxEntity(ModEntities.SPIRIT_FOX, client.world);
                    fox.readCustomDataFromNbt(list.getCompound(i));
                    entities.add(fox);
                }
                this.essenceLevel = data.getFloat("Essence");
            }
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        int slotX = x + 7;
        int slotY = y + 7;
        int slotW = 162;
        int slotH = 76;
        context.fill(slotX, slotY, slotX + slotW, slotY + slotH, 0xFF000000);
        renderCubeBlock(context,slotX + (slotW / 2),slotY + (slotH / 2), 10);
        //render3DAperture(context, slotX + (slotW / 2), slotY + (slotH / 2), mouseX, mouseY);
    }

    private void render3DAperture(DrawContext context, int centerX, int centerY, int mouseX, int mouseY) {
        MatrixStack matrices = context.getMatrices();
        float time = (client.world.getTime() + client.getTickDelta());
        float rotation = 230f; // Your preferred angle

        // 1. Render the Glass Shell (Full Size)
        renderBlock(context, Blocks.GLASS.getDefaultState(), centerX, centerY, 55f, rotation, 1.0f);
        // 2. Render the Water Volume (Inside)
        if (essenceLevel > 0) {
            // We push the water down so it fills from the bottom
            // Scaling Y moves the block's center, so we offset the position
            float waterY = centerY + (55f * (1.0f - essenceLevel) / 2f);
            renderBlock(context, Blocks.WATER.getDefaultState(), centerX, waterY, 53f, rotation, essenceLevel);
        }

        // 3. Render Floating Entities
        //entityPositions.clear();
        for (int i = 0; i < entities.size(); i++) {
            SpiritFoxEntity entity = entities.get(i);
            matrices.push();

            double angle = (time * 0.02) + (i * (6.28 / Math.max(1, entities.size())));
            double swimY = Math.sin(time * 0.05 + entity.getId()) * 10;
            float xOff = (float)Math.cos(angle) * 20;

            // Cache for clicking
            //entityPositions.put(i, new Vector2f(centerX + xOff, (float)(centerY + swimY)));

            InventoryScreen.drawEntity(context, (int)(centerX + xOff), (int)(centerY + swimY), 20,
                    (float)centerX - mouseX, (float)centerY - mouseY, entity);
            matrices.pop();
        }
    }

    private void renderCubeBlock(DrawContext context, int centerX, int centerY, int size) {
        MatrixStack matrices = context.getMatrices();
        BlockRenderManager blockRenderer = MinecraftClient.getInstance().getBlockRenderManager();

        matrices.push();
        matrices.translate(centerX, centerY, 200);
        matrices.scale(100f / size, -100f / size, 100f / size); // Scale to fit the aperture
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(230f));

        // Render a 3x3x3 grid of block
        for (int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++){
                for (int z = 0; z < size; z++) {
                    boolean isEdge =
                            (x == 0 || x == size-1 ||
                            y == 0 || y == size-1 ||
                                    z ==0 || z == size-1);
                    BlockState state = Blocks.GRAY_STAINED_GLASS.getDefaultState();
                    if (!isEdge) {
                        state = Blocks.AIR.getDefaultState();
                    }
                    matrices.push();
                    matrices.translate(x, y, z);

                    blockRenderer.renderBlockAsEntity(state,
                            matrices, context.getVertexConsumers(), 0xF000F0, OverlayTexture.getU(0.5f));
                    matrices.pop();
                }
            }
        }
        matrices.pop();
    }
    private void renderBlock(DrawContext context, BlockState state, float x, float y, float scale, float rotationY, float heightScale) {
        MatrixStack matrices = context.getMatrices();
        matrices.push();

        // Move to aperture center and apply 3D scale
        matrices.translate(x, y, 100);
        matrices.scale(scale, -scale, scale);

        // Apply the Pose
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-25.0f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationY));

        // Scale the Y specifically for water levels
        matrices.scale(1.0f, heightScale, 1.0f);

        // Center the block model (Standard blocks are 0 to 1)
        matrices.translate(-0.5, -0.5, -0.5);

        // Render the block using the standard manager
        MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(
                state, matrices, context.getVertexConsumers(),
                0xF000F0, OverlayTexture.DEFAULT_UV
        );

        matrices.pop();
    }
    private void renderItemBlock(DrawContext context, ItemStack stack, int x, int y, float scale) {
        MatrixStack matrices = context.getMatrices();
        matrices.push();

        // 1. Move and Scale
        matrices.translate(x, y, 150); // High Z to stay in front of background
        matrices.scale(scale, scale, scale);

        // 2. Custom Rotation (The "Aperture" Pose)
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-25.0f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(230.0f));

        // 3. Render the Item
        // Note: ModelTransformationMode.GUI is best for inventory items
        client.getItemRenderer().renderItem(
                stack,
                ModelTransformationMode.GUI,
                0xF000F0, // Full Brightness
                OverlayTexture.DEFAULT_UV,
                matrices,
                context.getVertexConsumers(),
                null, 0
        );

        matrices.pop();
    }
    private void drawInvertedVolume(MatrixStack matrices, float w, float h, float d, int color) {
        float x = w / 2.0f;
        float y = h / 2.0f;
        float z = d / 2.0f;

        float a = (float) (color >> 24 & 255) / 255.0f;
        float r = (float) (color >> 16 & 255) / 255.0f;
        float g = (float) (color >> 8 & 255) / 255.0f;
        float b = (float) (color & 255) / 255.0f;

        Matrix4f matrix = matrices.peek().getPositionMatrix();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        RenderSystem.enableCull(); // Culling ON makes the front faces disappear
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        // Front (Clockwise order -> Inverted)
        buffer.vertex(matrix, -x, y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, -y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y, z).color(r, g, b, a).next();

        // Back (Clockwise order -> Inverted)
        buffer.vertex(matrix, x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y, -z).color(r, g, b, a).next();

        // Bottom
        buffer.vertex(matrix, -x, y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, y, -z).color(r, g, b, a).next();

        // Top (Water Surface)
        buffer.vertex(matrix, x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, -y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y, -z).color(r, g, b, a).next();

        // Sides
        buffer.vertex(matrix, x, -y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, x, -y, -z).color(r, g, b, a).next();

        buffer.vertex(matrix, -x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, y, z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y, z).color(r, g, b, a).next();

        tessellator.draw();
    }
    private void drawInvertedCube(MatrixStack matrices, float size, int color) {
        float s = size / 2.0f;
        float a = (float) (color >> 24 & 255) / 255.0f;
        float r = (float) (color >> 16 & 255) / 255.0f;
        float g = (float) (color >> 8 & 255) / 255.0f;
        float b = (float) (color & 255) / 255.0f;

        Matrix4f matrix = matrices.peek().getPositionMatrix();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        // MUST enable Culling for the "inverse" effect to hide the near walls
        RenderSystem.enableCull();
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        // Front (Inverted)
        buffer.vertex(matrix, -s, s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, -s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, -s, s).color(r, g, b, a).next();

        // Back (Inverted)
        buffer.vertex(matrix, s, -s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, -s, -s).color(r, g, b, a).next();

        // Top (Inverted)
        buffer.vertex(matrix, s, -s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, -s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, -s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, -s, s).color(r, g, b, a).next();

        // Bottom (Inverted)
        buffer.vertex(matrix, -s, s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, s, -s).color(r, g, b, a).next();

        // Right (Inverted)
        buffer.vertex(matrix, s, -s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, s, -s, -s).color(r, g, b, a).next();

        // Left (Inverted)
        buffer.vertex(matrix, -s, -s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, s, -s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, s, s).color(r, g, b, a).next();
        buffer.vertex(matrix, -s, -s, s).color(r, g, b, a).next();

        tessellator.draw();
    }
    private void drawFace(Matrix4f matrix, BufferBuilder buffer, Vector3f p1, Vector3f p2, Vector3f p3, Vector3f p4, float r, float g, float b, float a, boolean invert) {
        if (invert) {
            // Clockwise (Inward)
            buffer.vertex(matrix, p1.x(), p1.y(), p1.z()).color(r, g, b, a).next();
            buffer.vertex(matrix, p4.x(), p4.y(), p4.z()).color(r, g, b, a).next();
            buffer.vertex(matrix, p3.x(), p3.y(), p3.z()).color(r, g, b, a).next();
            buffer.vertex(matrix, p2.x(), p2.y(), p2.z()).color(r, g, b, a).next();
        } else {
            // Counter-Clockwise (Outward)
            buffer.vertex(matrix, p1.x(), p1.y(), p1.z()).color(r, g, b, a).next();
            buffer.vertex(matrix, p2.x(), p2.y(), p2.z()).color(r, g, b, a).next();
            buffer.vertex(matrix, p3.x(), p3.y(), p3.z()).color(r, g, b, a).next();
            buffer.vertex(matrix, p4.x(), p4.y(), p4.z()).color(r, g, b, a).next();
        }
    }
    private void drawSolidCube(MatrixStack matrices, float size, int color) {
        float s = size / 2.0f;
        float a = (color >> 24 & 255) / 255.0f, r = (color >> 16 & 255) / 255.0f;
        float g = (color >> 8 & 255) / 255.0f, b = (color & 255) / 255.0f;

        Matrix4f matrix = matrices.peek().getPositionMatrix();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        RenderSystem.enableCull(); // Culling must be ON for the inversion to matter
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        // Side Vertices
        Vector3f nnn = new Vector3f(-s, -s, -s), nnp = new Vector3f(-s, -s,  s);
        Vector3f npn = new Vector3f(-s,  s, -s), npp = new Vector3f(-s,  s,  s);
        Vector3f pnn = new Vector3f( s, -s, -s), pnp = new Vector3f( s, -s,  s);
        Vector3f ppn = new Vector3f( s,  s, -s), ppp = new Vector3f( s,  s,  s);

        // --- CHANGE THESE TRUE/FALSE VALUES IN DEBUG MODE ---
        drawFace(matrix, buffer, nnp, pnp, ppp, npp, r, g, b, a, false);  // Front
        drawFace(matrix, buffer, pnn, nnn, npn, ppn, r, g, b, a, false);  // Back
        drawFace(matrix, buffer, nnn, nnp, pnp, pnn, r, g, b, a, true);  // Top
        drawFace(matrix, buffer, npn, ppn, ppp, npp, r, g, b, a, true);  // Bottom
        drawFace(matrix, buffer, pnp, pnn, ppn, ppp, r, g, b, a, false);  // Right
        drawFace(matrix, buffer, nnn, nnp, npp, npn, r, g, b, a, false);  // Left

        tessellator.draw();
    }
    private void drawVolume(MatrixStack matrices, float w, float h, float d, int color, boolean cull) {
        float x = w / 2.0f;
        float y = h / 2.0f;
        float z = d / 2.0f;

        float a = (float) (color >> 24 & 255) / 255.0f;
        float r = (float) (color >> 16 & 255) / 255.0f;
        float g = (float) (color >> 8 & 255) / 255.0f;
        float b = (float) (color & 255) / 255.0f;

        Matrix4f matrix = matrices.peek().getPositionMatrix();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        if (cull) RenderSystem.enableCull(); else RenderSystem.disableCull();
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        // Front (Inverted order to see INSIDE)
        buffer.vertex(matrix, -x, -y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x,  y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x,  y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x, -y,  z).color(r, g, b, a).next();
        // Back
        buffer.vertex(matrix, -x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x,  y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x,  y, -z).color(r, g, b, a).next();
        // Bottom
        buffer.vertex(matrix, -x,  y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x,  y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x,  y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x,  y, -z).color(r, g, b, a).next();
        // Top
        buffer.vertex(matrix, -x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x, -y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y,  z).color(r, g, b, a).next();
        // Sides
        buffer.vertex(matrix,  x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x,  y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x,  y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix,  x, -y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y, -z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x, -y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x,  y,  z).color(r, g, b, a).next();
        buffer.vertex(matrix, -x,  y, -z).color(r, g, b, a).next();

        tessellator.draw();
    }
    private void drawInsideFace(DrawContext context, MatrixStack matrices, float tx, float ty, float tz, float rx, float ry, int s, int color) {
        matrices.push();
        matrices.translate(tx, ty, tz);
        if (rx != 0) matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rx));
        if (ry != 0) matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(ry));

        // By rotating 180 here, we "flip" the visibility
        // so the face is only seen from the INSIDE of the cube.
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));

        context.fill(-s, -s, s, s, color);
        matrices.pop();
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, this.title, this.titleX, this.titleY, 4210752, false);
    }
    private int getDynamicEssenceColor() {
        float hue = (System.currentTimeMillis() % 10000) / 10000f;
        int rgb = Color.HSBtoRGB(hue, 0.7f, 0.9f);
        return (0xAA000000 | (rgb & 0x00FFFFFF)); // Add 0xAA for 66% transparency
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        int apertureX = x + 7;
        int apertureY = y + 7;
        int apertureW = 162;
        int apertureH = 76;
        if (mouseX >= apertureX && mouseX <= apertureX + apertureW &&
                mouseY >= apertureY && mouseY <= apertureY + apertureH) {
            ItemStack stack = handler.getCursorStack();
            if(stack.isOf(ModItems.TEST_POISON)) {
                this.client.interactionManager.clickButton(handler.syncId, -1);
                loadEntitiesFromData();
                return true;
            }
            // 2. Check if clicking a floating entity
            /**for (Map.Entry<Integer, Vector2f> entry : entityPositions.entrySet()) {
                Vector2f pos = entry.getValue();
                if (Math.abs(mouseX - pos.getX()) < 10 && Math.abs(mouseY - pos.getY()) < 10) {
                    // Tell Handler to RELEASE (index)
                    this.client.interactionManager.clickButton(handler.syncId, entry.getKey());
                    return true;
                }
            }*/
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}

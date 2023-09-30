package net.nikk.beyondcultivation.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.world.tree.custom.PeachtreeFoliagePlacer;
import net.nikk.beyondcultivation.world.tree.custom.PeachtreeTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLUM_BLOSSOM_KEY = registerKey("plum_blossom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PEACHTREE_KEY = registerKey("peachtree");
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        //RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        //RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        //RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        //RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);


        //List<OreFeatureConfig.Target> overworldPinkGarnetOres =
        //        List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PINK_GARNET_ORE.getDefaultState()),
        //                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_PINK_GARNET_ORE.getDefaultState()));

        //List<OreFeatureConfig.Target> netherPinkGarnetOres =
        //        List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_PINK_GARNET_ORE.getDefaultState()));

        //List<OreFeatureConfig.Target> endPinkGarnetOres =
        //        List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_STONE_PINK_GARNET_ORE.getDefaultState()));

        register(context, PEACHTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PEACHTREE_LOG),
                new PeachtreeTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.PEACHTREE_LEAVES),
                new PeachtreeFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        //register(context, PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPinkGarnetOres, 12));
        //register(context, NETHER_PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPinkGarnetOres, 9));
        //register(context, END_PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(endPinkGarnetOres, 8));

        //register(context, PETUNIA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
        //        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PETUNIA)))));

        //register(context, PINK_GARNET_GEODE_KEY, Feature.GEODE, new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
        //        BlockStateProvider.of(Blocks.DEEPSLATE),
        //        BlockStateProvider.of(ModBlocks.PINK_GARNET_ORE),
        //        BlockStateProvider.of(Blocks.DIRT),
        //        BlockStateProvider.of(Blocks.EMERALD_BLOCK),
        //        List.of(ModBlocks.PINK_GARNET_BLOCK.getDefaultState()),
        //        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
        //        new GeodeLayerThicknessConfig(1.7D, 1.2D, 2.5D, 3.5D),
        //        new GeodeCrackConfig(0.25D, 1.5D, 1),
        //        0.5D, 0.1D,
        //        true, UniformIntProvider.create(3, 8),
        //        UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
        //        -18, 18, 0.075D, 1));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(BCMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

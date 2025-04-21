package ing.boykiss.serversideadditions.mobpickup.util;

import ing.boykiss.serversideadditions.config.Config;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;

import java.util.HashMap;
import java.util.Map;

public class MobHeadData {
    private static final String MISSING_TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGY3ZjU3MmE3ZWJjYjVjNGRlNWEwZDMyYWU1OWI5OGNmODBmMzJhYWQ1ODBmOWFjMTZhYjk0YTRmNzdkZTA4MiJ9fX0=";

    private static final Map<ResourceKey<VillagerType>, Map<ResourceKey<VillagerProfession>, String>> VILLAGER_HEAD_TEXTURES = new HashMap<>();
    private static final Map<ResourceKey<VillagerType>, String> BABY_VILLAGER_HEAD_TEXTURES = new HashMap<>();

    static {
        // Credits to https://minecraft-heads.com/wiki/heads/heads-tag-trees

        // #Villagers
        // ##Desert
        Map<ResourceKey<VillagerProfession>, String> desertTextures = new HashMap<>();

        desertTextures.put(VillagerProfession.NONE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3Y2I1MzJmODViMzNiM2IxNDEwMjBhYTA1MWMzNWRjOGU5Y2MwYWUxM2VhMjU4ZjFkZmU1ZTA0NDVmM2JjYyJ9fX0=");
        desertTextures.put(VillagerProfession.ARMORER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBhM2U2Yzk2MWZiNGQ2ZWZjZjQ1NzY0NTVmY2QyN2JjNzg0MDEyNTZmZGYzOWIyNTQ4OGYzMTk4NGFmOTZiYSJ9fX0=");
        desertTextures.put(VillagerProfession.BUTCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGE2YjcxMzZkYjkwNmEyYWY1NGZkNDQ2MDk0ZjVkNGQwNzRjNDYyNTY2NWJjZTU3MDZhZDYyMDhiOGIzODNmOSJ9fX0=");
        desertTextures.put(VillagerProfession.CARTOGRAPHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZmMjVlYTFjMzlhM2Q3MzU3OWU1MzMwZTA0YzJiMTczYmEyZmQ1YzBjYTM0NTJiZTVmZjFhYWUwODNmNjMyOCJ9fX0=");
        desertTextures.put(VillagerProfession.CLERIC, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDI0YmE3NjBhNjFkZDI1NmM1MmIzMjUxMjlmNDYwMTZhZTg5MjIzMmEwZGVhMTcxNWY5OTdmN2M0ZDYyMmJlZiJ9fX0=");
        desertTextures.put(VillagerProfession.FARMER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzU1ZDYxYTI0MDllYjBiNDliM2U4OGIyODg4NDY3ZjIwYTNiMDYyMTJhMTBlN2I2ZWZiOWNlM2JjMWEwZTIwZiJ9fX0=");
        desertTextures.put(VillagerProfession.FISHERMAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQxMTExMTFlNTMyZDY4ZjBlNGY5MTNhNGUzYWVkZDBjOWRmYjI4NDdhOGFhZjFmZmE1MmIzZGFiY2ZmODZlZCJ9fX0=");
        desertTextures.put(VillagerProfession.FLETCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmQ0ZDEzYmFmNjVlZTE5N2RmYzZlYzI4NjU3ZDI1ZDg5ZjQ3MjY2MjIwNGUxM2NiZjc2MWY5NDEyYzg5MTMzNSJ9fX0=");
        desertTextures.put(VillagerProfession.LEATHERWORKER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWU2MWVjYmI4NjQ4N2VkMTZmZWRiMjc1ZGI5MmM5YzUwNDNhODMwZjUyZDk3M2JhNDRiMjhhNzc0MjAwNmI0MyJ9fX0=");
        desertTextures.put(VillagerProfession.LIBRARIAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWJmZjU5MDFiOTdlZmVmOTIyNTU1MzI1ZTkxMGE2ZDM1Y2M0Njk2N2ZmOGE3YzJhMGU1NzUzYWYyM2RkY2ZmMiJ9fX0=");
        desertTextures.put(VillagerProfession.MASON, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM0ZDdlYTAzODE4Nzc3MGNjMmU0ODE3YzkyMDllMTliNzRmNWQyODhlZDYzMzI4MWVjY2NhZjVjOGViYzc2NyJ9fX0=");
        desertTextures.put(VillagerProfession.NITWIT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk4YTI4YWE1ODhjNDRmZjRjOTM0NDZhN2MyOWQ4M2VmYWMxZTVmYzhlOTBkMWQ2YzM4NmM0MTA1ZGNhOGY3NyJ9fX0=");
        desertTextures.put(VillagerProfession.SHEPHERD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2UzNmMzNjZhZWIzMDM4NWNmZjE1MWE4Y2Y5MGJhYzVhODk3OWE1NWJjMmE4MDg4NzVlMjMzZDBmODFiMjRhOSJ9fX0=");
        desertTextures.put(VillagerProfession.TOOLSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjlkOTA0ZmRhZTY4ZmIxMjBlOWFlMGYzNTM3NDYwZjJhN2MxZGU5MTU5YWIzZjJiNDRjODQ0MDQ4ZmViYWJlYiJ9fX0=");
        desertTextures.put(VillagerProfession.WEAPONSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWJiYTY5ZjZlZTNlMTI4YmMyZmVlYzc4YzI0N2IyYTJmMDBjM2FlYTExZDg5MDZjNzI4ZGU5MmM2MGE1NDJlZCJ9fX0=");

        VILLAGER_HEAD_TEXTURES.put(VillagerType.DESERT, desertTextures);

        // ##Jungle
        Map<ResourceKey<VillagerProfession>, String> jungleTextures = new HashMap<>();

        jungleTextures.put(VillagerProfession.NONE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDRiMDYyYTlmODM5OWRjY2I2MjUxYTc0ZTYxODY0NzM0MmEzYzAyNDBjYTU2ZjM0NjE0ZDUyZjYwYTNmZWNlYyJ9fX0=");
        jungleTextures.put(VillagerProfession.ARMORER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWRhZDZjYThlYWU1MDViYWVhOGE0ZjJlY2ZmZTcxOWYzMTU1YTIyZDI4ZjgyZDgyZDUyODQ0MGYxYTc3YWExNCJ9fX0=");
        jungleTextures.put(VillagerProfession.BUTCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWE5ZTI0MjFjZGMwOWYyZWUyNzEwZTgwYmJlYTNmNjRmZjM1ZjcyOGNmZjhkZWZhOGQ4NzU0MGVmZTc5NjZkIn19fQ==");
        jungleTextures.put(VillagerProfession.CARTOGRAPHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzA4ODBjNDM2N2M0MTYyYTFkYmJiODhjZDg0ZTUyOTA2YjE4NjEyZjExODViZjZlZmU4MjQ0ZmVlMjkzOTc5OCJ9fX0=");
        jungleTextures.put(VillagerProfession.CLERIC, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODZlN2E5MGJiNTM5MDhjMTljY2Y3OTVlNmVhNWMxOWQwOTdiMTlmMWYxMTFmYzJmMzBhNjFlNjg5ZGE4YTRmZCJ9fX0=");
        jungleTextures.put(VillagerProfession.FARMER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdmMzM4YmNkOWZhYzBjNjY2ZjJhOTI1Y2YwN2Q5YjBmNWZhOWY1ZmQ5NDQzZjU5NTFjZTU0ZWM1YjAxNzYxMCJ9fX0=");
        jungleTextures.put(VillagerProfession.FISHERMAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdhOWU4YjFhZmU1ZWU1ZGQ0OTg3MzRjYzIyMWMxN2I3MWYxZGUxYTZkYzhlYWIyZmM4OGMzMzJlZDI0NGM5NyJ9fX0=");
        jungleTextures.put(VillagerProfession.FLETCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTllN2MwNTRhOGFiMmQ3ZjY0NDdkZTQzOGQzMzczMjM2MzJlOWMzZmNkYjMwZDM5YWMzMzZiNTIzZjg0ZTNlNiJ9fX0=");
        jungleTextures.put(VillagerProfession.LEATHERWORKER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjJhMzU0ZGI0YjBhNzMyZGQ4NDdkZmU0YWQwYTA3MjlhYmJjN2I4YzUwMGI5ZTYzODE5NTBjZTg1NmYxZGUzOSJ9fX0=");
        jungleTextures.put(VillagerProfession.LIBRARIAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U1OTk1MTA2ZDA4MGYxMGIyMDUyZGUwOGUzNTVmMzRhMjIxMzkwNGQ5ZDMyZjZkYzJkMWIyN2JlYzc1M2I3NCJ9fX0=");
        jungleTextures.put(VillagerProfession.MASON, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmZiOTM5MzBmOWQxMGEwNWFkYjg0YTY4MTZiZWU5MzBkNTI5NDRhNWUxYTY3ZjkwZjY1YzdmZWM0ZWM1YTY4YSJ9fX0=");
        jungleTextures.put(VillagerProfession.NITWIT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk4ODc5NWFlNTU2ODI5MTVjZTJjNzBmYmZiZTI0ZTQxNGU4ODJjNTBkNTJmMjI4MWQwNzA0ODhhYzE4MTE1In19fQ==");
        jungleTextures.put(VillagerProfession.SHEPHERD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM4YmMzODFmNzRjZTU4ZTg2ZDlkNDE3ZDUxMjVmYjcyZTc1OGM1OGQ5M2YzNGNhZmM4NmQxZmM1MTQ0N2Q1MyJ9fX0=");
        jungleTextures.put(VillagerProfession.TOOLSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZlYzYxMDk3ZTExYmZlNmYxMGFhYTEyZTVjMGE1NGM4MjliZGJkOWQ5ZDdhMzJmYzYyN2U2YjVhOTMxZTc3In19fQ==");
        jungleTextures.put(VillagerProfession.WEAPONSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjVmYWZhMmJlNTViZDE1YWVhNmUyOTI1ZjVkMjRmODA2OGUwZjRhMjYxNmYzYjkyYjM4MGQ5NDkxMmYwZWM1ZiJ9fX0=");

        VILLAGER_HEAD_TEXTURES.put(VillagerType.JUNGLE, jungleTextures);

        // ##Plains

        Map<ResourceKey<VillagerProfession>, String> plainsTextures = new HashMap<>();

        plainsTextures.put(VillagerProfession.NONE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE0YmZmMWEzOGM5MTU0ZTVlYzg0Y2U1Y2YwMGM1ODc2OGUwNjhlYjQyYjJkODlhNmJiZDI5Nzg3NTkwMTA2YiJ9fX0=");
        plainsTextures.put(VillagerProfession.ARMORER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUyMmRiOTJmMTg4ZWJjNzcxM2NmMzViNGNiYWVkMWNmZTI2NDJhNTk4NmMzYmRlOTkzZjVjZmIzNzI3NjY0YyJ9fX0=");
        plainsTextures.put(VillagerProfession.BUTCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY3NzRkMmRmNTE1ZWNlYWU5ZWVkMjkxYzFiNDBmOTRhZGY3MWRmMGFiODFjNzE5MTQwMmUxYTQ1YjNhMjA4NyJ9fX0=");
        plainsTextures.put(VillagerProfession.CARTOGRAPHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQyNDhkZDA2ODAzMDVhZDczYjIxNGU4YzZiMDAwOTRlMjdhNGRkZDgwMzQ2NzY5MjFmOTA1MTMwYjg1OGJkYiJ9fX0=");
        plainsTextures.put(VillagerProfession.CLERIC, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTg4NTZlYWFmYWQ5NmQ3NmZhM2I1ZWRkMGUzYjVmNDVlZTQ5YTMwNjczMDZhZDk0ZGY5YWIzYmQ1YjJkMTQyZCJ9fX0=");
        plainsTextures.put(VillagerProfession.FARMER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTVhMGIwN2UzNmVhZmRlY2YwNTljOGNiMTM0YTdiZjBhMTY3ZjkwMDk2NmYxMDk5MjUyZDkwMzI3NjQ2MWNjZSJ9fX0=");
        plainsTextures.put(VillagerProfession.FISHERMAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWMxNWU1ZmI1NmZhMTZiMDc0N2IxYmNiMDUzMzVmNTVkMWZhMzE1NjFjMDgyYjVlMzY0M2RiNTU2NTQxMDg1MiJ9fX0=");
        plainsTextures.put(VillagerProfession.FLETCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTc1MzJlOTBjNTczYTM5NGM3ODAyYWE0MTU4MzA1ODAyYjU5ZTY3ZjJhMmI3ZTNmZDAzNjNhYTZlYTQyYjg0MSJ9fX0=");
        plainsTextures.put(VillagerProfession.LEATHERWORKER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjc2Y2Y4YjczNzhlODg5Mzk1ZDUzOGU2MzU0YTE3YTNkZTZiMjk0YmI2YmY4ZGI5YzcwMTk1MWM2OGQzYzBlNiJ9fX0=");
        plainsTextures.put(VillagerProfession.LIBRARIAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTY2YTUzZmM3MDdjZTFmZjg4YTU3NmVmNDAyMDBjZThkNDlmYWU0YWNhZDFlM2IzNzg5YzdkMWNjMWNjNTQxYSJ9fX0=");
        plainsTextures.put(VillagerProfession.MASON, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmMwMmMzZmZkNTcwNWFiNDg4YjMwNWQ1N2ZmMDE2OGUyNmRlNzBmZDNmNzM5ZTgzOTY2MWFiOTQ3ZGZmMzdiMSJ9fX0=");
        plainsTextures.put(VillagerProfession.NITWIT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzVlNzk5ZGJmYWY5ODI4N2RmYmFmY2U5NzA2MTJjOGYwNzUxNjg5NzdhYWNjMzA5ODlkMzRhNGE1ZmNkZjQyOSJ9fX0=");
        plainsTextures.put(VillagerProfession.SHEPHERD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTllMDRhNzUyNTk2ZjkzOWY1ODE5MzA0MTQ1NjFiMTc1NDU0ZDQ1YTA1MDY1MDFlN2QyNDg4Mjk1YTVkNWRlIn19fQ==");
        plainsTextures.put(VillagerProfession.TOOLSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2RmYTA3ZmQxMjQ0ZWI4OTQ1ZjRlZGVkZDAwNDI2NzUwYjc3ZWY1ZGZiYWYwM2VkNzc1NjMzNDU5ZWNlNDE1YSJ9fX0=");
        plainsTextures.put(VillagerProfession.WEAPONSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU0MDliOTU4YmM0ZmUwNDVlOTVkMzI1ZTZlOTdhNTMzMTM3ZTMzZmVjNzA0MmFjMDI3YjMwYmI2OTNhOWQ0MiJ9fX0=");

        VILLAGER_HEAD_TEXTURES.put(VillagerType.PLAINS, plainsTextures);

        // ##Savanna

        Map<ResourceKey<VillagerProfession>, String> savannaTextures = new HashMap<>();

        savannaTextures.put(VillagerProfession.NONE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTIyNTY4MzU0ZjUzNWIwOTQwMzVjZWU4NjhhNGY3OTg1Nzg4YmQ1NzU1YjgwYzBkYzhkZmM0NDM5NjlmYWVhNyJ9fX0=");
        savannaTextures.put(VillagerProfession.ARMORER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI2Y2Q5YTlmYjRiMTNmNDlkMjViODJhMTQwNDBjMDQ1ZmY1N2FhOGMyNzljY2UyMGEyNTAzYjgxODRkOWI5YyJ9fX0=");
        savannaTextures.put(VillagerProfession.BUTCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2NzE1MTE1ZGU3NjZjOTQ5ZTg3MDBiNzY1MGM4OTk0ZmQzZWViOTdiZDE4MzZjMmUxNmI1ZDhkNTU1MWI1ZCJ9fX0=");
        savannaTextures.put(VillagerProfession.CARTOGRAPHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjJmOTQ0MjIyZmY2OTNmZTA4OGJkNTQzYzhlZmRkMzI0NmVhYjZhMzQ5NzhhY2RlNzc0ZjdlMjk1ZGVlOWUxNiJ9fX0=");
        savannaTextures.put(VillagerProfession.CLERIC, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZjYzhmYTgzNzk2NjVmYmI4YzkyNGU0NTIzNWRhMWM5ODhjMWM1MjNhZjFiMjQ3OTc5NmQ0YTQ5YWYxYzVjOCJ9fX0=");
        savannaTextures.put(VillagerProfession.FARMER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljOTRmYWE3YWM5YjA3NTJkYzdkYTczODZiNGQ4ZmMzNGUyOTE2ZGE1YjAxNzg5Mjc1YmJjYjdkZmNlN2ZjYiJ9fX0=");
        savannaTextures.put(VillagerProfession.FISHERMAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmFjYWNlZjVmMDRiZWQ0MmU4YTgwOGNjZWMzOTg4OWU2NjZmYjEyOTllOTlhOWUwOTA2MGY4Y2YyOWU2YmFmNiJ9fX0=");
        savannaTextures.put(VillagerProfession.FLETCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFjMjIyZWZjNmFiNGJkMWM3MDM1MWRlMDA3ZTM3YmYzZDAyOGMxZDkzZjA4ZWZlYWVhOGEwN2VjYjYyODY3YiJ9fX0=");
        savannaTextures.put(VillagerProfession.LEATHERWORKER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjQ1Yzk5YzgwZDAzNDVjNGJlM2ZjM2EyZjBkMDVhM2UyM2E1YzRiZjdlOTkxNTY4ZWVlNjRhNjgwNmYwNDhjMCJ9fX0=");
        savannaTextures.put(VillagerProfession.LIBRARIAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzFmNzE0MTMzY2U3OGQxMTgxYzRkNWQzZTUzNzExZWNlMTBjNGM5YTI4MjAxMTg4ZWUxYTZmMzVjYzBmYTNjYSJ9fX0=");
        savannaTextures.put(VillagerProfession.MASON, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDAwMzY0Yzk4YWYwNTlhZTZkNTgxZmNhNjAzOGJlZTE0Yjg2OTk5OGZiM2FhMzgyYjNjNDc3NWQ1NGU4NDgxZiJ9fX0=");
        savannaTextures.put(VillagerProfession.NITWIT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGQ5ZWU1ZDhiNThmZGRkMjdiYzY3OWMwNTQ4ZjU1YmFhODQ1ZjlmMWRmNWU4OGM3YzViZGE2ZWI5ZGYyYjM5OSJ9fX0=");
        savannaTextures.put(VillagerProfession.SHEPHERD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDMxYzBmNDYwM2I1MWViNmQ4ODkyZjhlYzBiNTIwOTc5MDQxZDY3MWI4ZDM3OGM4YjI2ZDA5N2I4ZjdlMTMyNyJ9fX0=");
        savannaTextures.put(VillagerProfession.TOOLSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2Q1ODZmNTViZTQyOWRiNjg5YzA3MGM0N2FhOWIxMjg0Y2Q1MWRhNDkzNzY4NTU5ZDcxMzJkZjhjODkxNmFlZCJ9fX0=");
        savannaTextures.put(VillagerProfession.WEAPONSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzFiZWFhMDk5YzgyMzMzMmU3NzgwYTMyMTEwZjViMGJmYzI1NDZlNTNmZGU4ZTIwNjgxNzMyNTg5NDAxOGYzIn19fQ==");

        VILLAGER_HEAD_TEXTURES.put(VillagerType.SAVANNA, savannaTextures);

        // ##Snow

        Map<ResourceKey<VillagerProfession>, String> snowTextures = new HashMap<>();

        snowTextures.put(VillagerProfession.NONE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjBjNjQxZTNkMzc2NGVkMWMxZjE5MDdjNDMzNGUyYjEzMDNlMjE1MmIxM2QxZWIwYzYwNTc2M2Y5N2ZiMjU4YSJ9fX0=");
        snowTextures.put(VillagerProfession.ARMORER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWRjYjIxMDkwY2Q3ZTk3MDY2YTFmMWRjYWU3NzhjZGEwMzJkZjhhZjk1Mzc2N2QyYTA0ZjRhNzhkY2ZjMjQ5NiJ9fX0=");
        snowTextures.put(VillagerProfession.BUTCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2JiNWJmYTlhYzU0MTJlN2QxMTZmOWQ0MjRlMGZkM2ZhNDBlZWRjMmMzZTdjOTA2YzA1NWJiNWY0YzVjNTg3YSJ9fX0=");
        snowTextures.put(VillagerProfession.CARTOGRAPHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDE0Mzg5NWIwNGNjZTdiM2FkOTU2NjIwYmI0OGQxYWFhYTZiYmRjYzEwYmIzYThjNGFhMGE1NTkzOWYwNTBiZSJ9fX0=");
        snowTextures.put(VillagerProfession.CLERIC, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2UzZDM2MzVjZTQxMWFiZjFlNGYzNzNkMTYxZDA3YjhjNDdlMzU5YjZjNTZmNzRiNDEzY2I0OTRhYzc0NmUyZCJ9fX0=");
        snowTextures.put(VillagerProfession.FARMER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmQ5NWFkM2YzN2JiMzIzNzg1ZjhkNjgxNjc2M2U1YTczOWUyODE0ZDYxMWE3YWI0YWZmZjk3NmY5MTcyOWZhZiJ9fX0=");
        snowTextures.put(VillagerProfession.FISHERMAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjFkNjQ0NzYxZjcwNmQzMWM5OWE1OTNjOGQ1ZjdjYmJkNDM3MmQ3M2ZiZWU4NDY0ZjQ4MmZhNmMxMzlkOTdkNCJ9fX0=");
        snowTextures.put(VillagerProfession.FLETCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWUxMjYxNTgyMjBlOTQ2NTE3YjJjMjBlMTM4MDU5MjhkZjA2ZTE5YzExMDFiZGVhMmJjNWE0ZmM5NWY5YzAxMSJ9fX0=");
        snowTextures.put(VillagerProfession.LEATHERWORKER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBlNGFhNmY1NDU1ZTMyMTA1OWUyMDJhYmM5ZDllMjM2NzU2NjMwNzBlOTJhMDc5ZThjYjU0NGY3YmU0Yzc1NSJ9fX0=");
        snowTextures.put(VillagerProfession.LIBRARIAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTgwNmY5NzY3ZjA4N2UzZTRjMDlhZDAxMmJmZDA2M2QwMTNiYTRjMzE2OWZiYjBlZmQ3NTM4ZTI4ZDdkODNkIn19fQ==");
        snowTextures.put(VillagerProfession.MASON, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjZhNWE0YjQ5MmNmMzg2MWQzMDQ0YTkxMWUxMzY0ZGFkZjdhMmJlNDFmYjJmOWE1YzYxOWRlNWNjOWE1YWYwMCJ9fX0=");
        snowTextures.put(VillagerProfession.NITWIT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2NjMDIzNzJmNjI5MmExMzFhYTAzNWNlZjhlNTI0NzVlZmE5NjYzNTJlMDVjMmRiYTM3NGYxMzA5ZTU2OWRiYiJ9fX0=");
        snowTextures.put(VillagerProfession.SHEPHERD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE2NDRhNTUyZGQwNmY3OTc0MTNjMDAyZDQxZGE1MjkwNGE3YmNmZDc0NGM1ZDJjMWZlMzQ4ZDlmNjZjYmJlYiJ9fX0=");
        snowTextures.put(VillagerProfession.TOOLSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmU3ZGIzYTVjYjVkZDY4MTFmYTg3ZTJkMTEzYWE2MDU3YzY2OTA3OGRkNjJmZjI4YjM3N2YxNjgyNzdkOTVjZSJ9fX0=");
        snowTextures.put(VillagerProfession.WEAPONSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjg0NGUzZmZjYzE3ZDRhYjBkMGVlYmI2YmZkYjk2MDNlMmY3YTA5NWQ3MDAwMjhjOWRiMjc1YWUxYTk1ZTdmMiJ9fX0=");

        VILLAGER_HEAD_TEXTURES.put(VillagerType.SNOW, snowTextures);

        // ##Swamp

        Map<ResourceKey<VillagerProfession>, String> swampTextures = new HashMap<>();

        swampTextures.put(VillagerProfession.NONE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTFkZjFmZDBmOTkzN2M2MzFjNmVjMjZlNGI0ZWM2MWRkNmJhMWRmYjJiYTA3OGY0NjM3OWQ5OTNlZTg4ZDczNSJ9fX0=");
        swampTextures.put(VillagerProfession.ARMORER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWE3YWJiMTI3YjY5MzM4YTgxYjg3YTE3YjY2NDIxNGVlOWZlMDQzN2M4YjU3N2EwZTM2NzRiMWM2ZDBmY2E3NyJ9fX0=");
        swampTextures.put(VillagerProfession.BUTCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTM5MzM3MDQ0NGVlOTE1NTk1NjMwY2Q5MDBkMDY1YzAzY2M1YzYxZjdhOTFlZGQ4ZmVjMjRmMjA0YjNlZWI0ZiJ9fX0=");
        swampTextures.put(VillagerProfession.CARTOGRAPHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmUwNDA5ODMzMjhkYTQyYjRlZGE5MzFiZGNlZmIzOWE4ODE2YjMyMDQ1ZGExZWQ5ZjMzNWU1MzhjMThmM2M0MSJ9fX0=");
        swampTextures.put(VillagerProfession.CLERIC, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWE4ZTNlMjI0YTc2OGJiNTc3MWQ2ZTQ2NTNlNDhhNTRmZTZjZDA5NWZjMzk5ZDNlYzM5Yjk1YzI1NDRhZjA1NCJ9fX0=");
        swampTextures.put(VillagerProfession.FARMER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTJjZmM3ZWFkZTAxNmE5NjljMmIzYTg3ZTAxMGEwMmFjOTEwZGY2MGQzNzE0Zjc2MTg0YjJjMTdhNzAzMTAxZSJ9fX0=");
        swampTextures.put(VillagerProfession.FISHERMAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDIyMzY2NDg4NmQ5NjY0M2QzYWZkYzRhMmFjNzJlYmMyYmNkMjI5ZTUxNzUxOWUxNWMzZTdjMTU3MGFkNzQ1ZSJ9fX0=");
        swampTextures.put(VillagerProfession.FLETCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTJlZDkzMWVlNmI3NzUzOWQyZmQ3ZDI3MTYxN2RiNmIxOTM2NWNiMGUzYzUyZWFjMDA1MjcyMzAxZDA3YWM3NCJ9fX0=");
        swampTextures.put(VillagerProfession.LEATHERWORKER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTAwN2M0YTNlM2I4ZDMxYjk0YTk1MTczYmMyYWVhNGI3MThjMTUwZjAxNjZmMGM5NjRjYTllMDRiZTY2NGEyMiJ9fX0=");
        swampTextures.put(VillagerProfession.LIBRARIAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc0NzM1OTZhMWNiNDBjZjFiM2VjNWY0NmYyZjlkNTkwZDVlNzhkMDUwNzY4MGE3YjliYzQzMDQ1ODdkYTBjOSJ9fX0=");
        swampTextures.put(VillagerProfession.MASON, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGIxNzQyN2Q0ZTlkODlmYTFlMmNiMjk3Y2QxNDZlZDJmZGI0OTcyMWEwZWFiZjA0OGU3ZTdkMjRjNzNmY2RhNSJ9fX0=");
        swampTextures.put(VillagerProfession.NITWIT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjhjMGRkMDc5N2ZkMWVlOWYxODQ5ZDRhYzFlYmI4NzFhZjdmZTYxMGM5Y2E2MTY2MGNlMTEyYmU4NDJmNmI0MSJ9fX0=");
        swampTextures.put(VillagerProfession.SHEPHERD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjljZjE4YjA0NDdmZjFkZmNmYmE5ZTRjNGFjN2Y2ZTI2YTk4NjM1MmRkMTg3OGM2YTFlMDBkMGY1ZGQ2MjExZCJ9fX0=");
        swampTextures.put(VillagerProfession.TOOLSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWQwNzRiMjZiMDljNjdmZWVmZWE0ZTAyNDVmNjMzMDZlNDVjYjkzNWU5OGRiZmFhMzAyMGViNDBjNzA2OTcxOSJ9fX0=");
        swampTextures.put(VillagerProfession.WEAPONSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDYyNWM2NGJlZGVkMTg3NWI4Y2Q5ZmRmODEwZjE2NDMwZTc0MTk3MzcxNTcyMDI0YjczMDdmMjY2Mzc1NzNmNiJ9fX0=");

        VILLAGER_HEAD_TEXTURES.put(VillagerType.SWAMP, swampTextures);

        // ##Taiga

        Map<ResourceKey<VillagerProfession>, String> taigaTextures = new HashMap<>();

        taigaTextures.put(VillagerProfession.NONE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzdkMjE0N2FjNDdhMWM5NTg4NTU3ZjkyZjgzMTA5MjYyYTkzZWNmMzIxNzBhYThiNjIwNTZlMTYyOWY3OTBhMiJ9fX0=");
        taigaTextures.put(VillagerProfession.ARMORER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZjOWZiZTE0MjJkNWIwZWRiZTA2NTBlNTExYjFkOWMyMjkxNDYwNzUyYjA2NmM0ZjcwMWMwMjk3YTYyMDFlOCJ9fX0=");
        taigaTextures.put(VillagerProfession.BUTCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODliOTIxY2E5ZTVlN2E0M2ViYjkwNGNhNWI4MzNkNWM5YjM3ZjBmZTAzOWU5MTEyMzAzYzBmOWIxODhhYjczOSJ9fX0=");
        taigaTextures.put(VillagerProfession.CARTOGRAPHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UxZmI1MmI3YWU4MmJiMDkxYzU0YzMzYjdmYTZiODBjOGEwMjUwMzcyYjlkMWNiZDZmNzk2NTIyZjY0NzlkIn19fQ==");
        taigaTextures.put(VillagerProfession.CLERIC, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGJmYWQzYjBmYzhkMTlhN2RkYTY4MDg3Y2Y1YTVlNjg2NWNjOWZhZjJlNzllZGYxMGFmNGJmYTcwYTRkNGJkOSJ9fX0=");
        taigaTextures.put(VillagerProfession.FARMER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjA4YmRiNTNjNTVmZWYzMmEwNjU4ZTFjNzk2NjYxNGFmMGJmZjYwOTEyNDliOGZlM2I3N2EwMjc1ZGE4MmU0MyJ9fX0=");
        taigaTextures.put(VillagerProfession.FISHERMAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWM3ZjQ0YjUxMWY3MDYzMTg3ZDBmZTEyYzc0YTBjYjhjOTNmMzRkMGY1ODczMzhiMmE5YzIyZjNmYTJmMjEyIn19fQ==");
        taigaTextures.put(VillagerProfession.FLETCHER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTljNDVlZDIzOGUwYjBjNjY0ZGRlMDlkZTY0YmE5ZTYwMzhkZDIzMWRkNTg0NjZmYmRjZGNjOTExZTBmZmJkMiJ9fX0=");
        taigaTextures.put(VillagerProfession.LEATHERWORKER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzBjNmMzYTkxM2FmOTI5M2Q2MzcyYjBiZDRjMmRlMmNjNmQzYjZlNDczZTNmYTBmZmYwMzQ3NDFhNjEyODI5ZCJ9fX0=");
        taigaTextures.put(VillagerProfession.LIBRARIAN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRmMDRlYjIwY2QwYjgyYWFlZjI1MjBhZWQ5ODY3YzNjY2EyNDdhNGNkOTc1YTEyZWE1MGRmMDNhNzE3NjI0MSJ9fX0=");
        taigaTextures.put(VillagerProfession.MASON, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxZWM2MTJmOGY3ODk4NGEwOGY4MjkwYmQzZjFjMTg5MmI0Zjc4MjdiNTI0ZGJhYjdlYWFjYzlkZDllMjJiMiJ9fX0=");
        taigaTextures.put(VillagerProfession.NITWIT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTUwYjYzM2QyMTQ1NTAxMDYzODAzNWZmNjlkMjA0ZmFjNDRiM2Y5ZTI5YTcwODM2ZTM1NGJmNzI2ZTAxYzgzIn19fQ==");
        taigaTextures.put(VillagerProfession.SHEPHERD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDU3NzFiNzM4MzQ5ZDFkZTBlMDFlODk0YWU0MDE2ODZmNTk4Y2ExOWEyMDg4YjA5NTE0OWZkZTliNzZhNDM3NyJ9fX0=");
        taigaTextures.put(VillagerProfession.TOOLSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWE4NTEyNTg0OTEzNDFjMDAxNDlhOWM5MmRlMWFjZGU2NjViMTMxYzhhNzRjOWZmZTBjYjFlM2E1YWQ5NzQ5In19fQ==");
        taigaTextures.put(VillagerProfession.WEAPONSMITH, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGUwMmZlYmI0YzUyZGIxZmI5ZTFlNWM4NTJhNGU3MmQ4ZGZlNmM0YzA1NWE0NjQ5YWJmM2QzNTdkMjMzZmMxYiJ9fX0=");

        VILLAGER_HEAD_TEXTURES.put(VillagerType.TAIGA, taigaTextures);

        // #Baby Villager
        BABY_VILLAGER_HEAD_TEXTURES.put(VillagerType.DESERT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZThjOGIzMmI4Njc1ZjE4NmVjNmFhNTI2Y2M2YmQyYTQ4NTIyYjNlZTdhNDUyYzczMTNmNGFkYmRkNmQ5YmNmZCJ9fX0=");
        BABY_VILLAGER_HEAD_TEXTURES.put(VillagerType.JUNGLE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQwMDdjZDQ3NWFkZWEwOWJiZTYzMmVkYmMyMTM3Mzg4ZDM1NmZlYmZiMzQ2NzU4N2M0YjU2YWY1MjVlN2MyIn19fQ==");
        BABY_VILLAGER_HEAD_TEXTURES.put(VillagerType.PLAINS, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzkxNzc0ZThlNDNjZjUzNWUzMDk3MTZhMDNiNGE0YTgxMTA4NzkzZGU3NjhlYmQzZjEyMjRlNjgwMjFmZTk3ZSJ9fX0=");
        BABY_VILLAGER_HEAD_TEXTURES.put(VillagerType.SAVANNA, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTgwMWQ4MTU1MGM0ZjBhYWYwMGJlODNmMDI4MTVmMGFhNzk3OTc5OTZkY2ZkNWUxZmFkMjgzMzI3OWE0MjcyYyJ9fX0=");
        BABY_VILLAGER_HEAD_TEXTURES.put(VillagerType.SNOW, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjc1MjQyOTRiMjRkNDg5MTJiZDM4NmZmYmU3NTU2MThmMTgwODU0NjRiNmQ3NTA1MTE4YTdiMmVlM2FhMDBhZSJ9fX0=");
        BABY_VILLAGER_HEAD_TEXTURES.put(VillagerType.SWAMP, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDY3ZWZiNWI0ZjBmODgyYzdmMmIxYWUxMWE3MDk4Y2Y4ZDY1NTgxNGM2ZjMzZjFkMTg1NTE2ZWE5YzZhNmVhYiJ9fX0=");
        BABY_VILLAGER_HEAD_TEXTURES.put(VillagerType.TAIGA, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzM3M2MyYzdkNGE0Y2MxMTlmN2FkZjRiMmVmYjEwMTEwMWRmNWQ3NzU2MjYyMDgxN2E2M2QxMmYwMTQ4YzA2ZiJ9fX0=");
    }

    public static String getHeadTexture(Entity entity) {
        if (entity instanceof Villager) {
            return getVillagerHeadTexture((Villager) entity);
        }

        // TODO: Add support for other mobs

        return MISSING_TEXTURE;
    }

    public static String getVillagerHeadTexture(Villager villager) {
        VillagerData villagerData = villager.getVillagerData();

        Holder<VillagerType> villagerType = villagerData.type();
        ResourceKey<VillagerType> villagerTypeKey = villagerType.unwrapKey().orElse(null);

        Holder<VillagerProfession> villagerProfession = villagerData.profession();
        ResourceKey<VillagerProfession> villagerProfessionKey = villagerProfession.unwrapKey().orElse(null);

        if (villagerTypeKey == null || villagerProfessionKey == null) {
            return MISSING_TEXTURE;
        }

        if (villager.isBaby() || Config.INSTANCE.getMobPickup().isAllVillagersAsPlushies()) {
            if (!BABY_VILLAGER_HEAD_TEXTURES.containsKey(villagerTypeKey)) {
                return MISSING_TEXTURE;
            }

            return BABY_VILLAGER_HEAD_TEXTURES.get(villagerTypeKey);
        }

        if (!VILLAGER_HEAD_TEXTURES.containsKey(villagerTypeKey)) {
            return MISSING_TEXTURE;
        }
        Map<ResourceKey<VillagerProfession>, String> professionTextures = VILLAGER_HEAD_TEXTURES.get(villagerTypeKey);

        if (!professionTextures.containsKey(villagerProfessionKey)) {
            return MISSING_TEXTURE;
        }
        return professionTextures.get(villagerProfessionKey);
    }
}

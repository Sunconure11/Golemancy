# Golemancy

Golemancy is a mod about capturing the souls of mobs, breeding them, and using them to create faithful golem servants to do your bidding. You can create golems that will fight for you, gather items, and otherwise automate your Minecraft world! This mod is for Fabric, and no Forge port is currently planned.

## Requirements

- [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
- [Cloth Config API](https://www.curseforge.com/minecraft/mc-mods/cloth-config) v6.1.48+
- [ModMenu](https://www.curseforge.com/minecraft/mc-mods/modmenu) is not required, but is supported.

## Capturing Souls

You can make an empty soulstone by putting nether quartz into a stonecutter:

![empty soulstone recipe](/readme/empty-soulstone.png)

Next you'll need to kill some mobs. If you kill a mob whose soul can be captured and you have an empty soulstone in your inventory, it will be filled up.

![a filled soulstone](/readme/filled-soulstone.png)

The following soul types can be obtained from mobs:

* Covetous Soul - comes from Endermen. They can pick up items and put them in their linked inventory.
* Curious Soul - comes from Slimes. If you give them a "block" item (i.e. a silk-touched diamond ore) to hold, they will stare at any nearby instances of that item - even through walls!
* Entropic Soul - comes from Creepers and Silverfish. Link them to a block, and they'll break any instances of that block they find nearby. They'll need a high strength to break very hard blocks!
* Hungry Soul - comes from Hoglins and Zombies. They'll pick up items and eat them, destroying them. They can eat any item.
* Intrepid Soul - comes from Shulkers. They are ranged golems that throw clay balls at enemies.
* Marshy Soul - comes from Drowned. Give them a fishing rod, and they will fish for you - smarter and more agile golems will fish faster and produce less junk. However, they can't fish treasure.
* Parched Soul - comes from Blazes and Husks. They can fill buckets from fluid blocks and store them in their linked inventory. They can also get empty buckets from their linked inventory.
* Restless Soul - comes from Skeletons. They wander around randomly, but don't do much else... do they?
* Tactile Soul - comes from Phantoms. They'll right-click their linked block every few seconds, like a player.
* Valiant Soul - comes from Ravagers and Guardians. You can equip them with tools by right-clicking, and they'll fight off enemies.
* Weeping Soul - comes from Ghasts. They can heal other golems and even other types of pets, like wolves.

The following soul types can be obtained by random mutation in the soul grafter:

* Careful Soul - comes from grafting Covetous and Curious souls. They will extract items from their linked chest and "sort" them into any container nearby that contains at least 1 of the same item.
* Rustic Soul - comes from grafting Covetous and Entropic souls. They are similar to Entropic golems, but they'll break any crops, gourds, or 2-block sugarcanes they find nearby.
* Verdant Soul - comes from grafting Covetous and Tactile souls. They will take seeds from a linked chest and plant them on any empty farmland they find nearby.

## Making Golems

Soulstones aren't useful without a body to inhabit, so the next step is to make a clay effigy:

![clay effigy recipe](/readme/clay-effigy.png)

Right-click to put the effigy in the world. Then right-click on it with a soulstone to turn it into a golem!

![a golem in the world](/readme/golem.png)

You can also bake the clay effigy in a blast furnace before placing it to create a terracotta golem with extra armor.

![a terracotta golem](/readme/terracotta.png)

Terracotta golems can also be dyed!

![dyed terracotta golems](/readme/terracotta-dyed.png)

## The Golem Wand

The golem wand can be used to interact with your golems:

![golem wand recipe](/readme/golem-wand.png)

Hold the golem wand in your hand and right-click on one of your golems to make them follow you. Right click again to tell them to stop. You can also right-click on blocks, which will cause any nearby golems who are currently following you to instantly teleport to you.

If you right-click a golem while sneaking, you'll enter "linking mode". You can then right-click on a block to link the golem to that block. Link a golem to itself to unlink it. Golems consider their linked block as "home" and will return to it when they're not busy doing something else. Some golems can, if linked to a chest or other inventory, extract or insert items into their linked block.

## The Soul Mirror

Each soul has a set of attributes and genetics that determine its type and abilities. You can check the genes of your soulstones with a soul mirror:

![soul mirror recipe](/readme/soul-mirror.png)

To use the soul mirror, just hold it in your off-hand and right-click with a soulstone in the other hand.

![soul mirror screen](/readme/soul-mirror-screen.png)

## The Soul Grafter

You can breed (or "graft") soulstones together to produce new results. To do so, you'll need to craft a soul grafter using any filled soulstone:

![soul grafter recipe](/readme/soul-grafter.png)

The soul grafter is what you use to breed soulstones. You'll need a good supply of empty soulstones and bone meal to keep it running, though:

![soul grafter screen](/readme/soul-grafter-screen.png)

# Planned Features

* More advanced golem mutations, such as smelters, butchers, etc.
* In-game documentation via Patchouli.

# Credits

Some textures are adapted from the excellent Malcolm Riley's [unused-textures](https://github.com/malcolmriley/unused-textures) repository, namely:

* The soul mirror item.
* The soul grafter block.
* The soulstone item.

These assets are licensed under [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/).
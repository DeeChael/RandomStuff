import json
import os

BLOCK_STATE_TEMPLATE = '''{
  "variants": {
    "type=east": {
      "model": "ds_random_stuff:block/oak_vertical_slab",
      "y": 0,
      "uvlock": true
    },
    "type=west": {
      "model": "ds_random_stuff:block/oak_vertical_slab",
      "y": 180,
      "uvlock": true
    },
    "type=north": {
      "model": "ds_random_stuff:block/oak_vertical_slab",
      "y": 270,
      "uvlock": true
    },
    "type=south": {
      "model": "ds_random_stuff:block/oak_vertical_slab",
      "y": 90,
      "uvlock": true
    },
    "type=double": {
      "model": "minecraft:block/oak_planks"
    }
  }
}'''

LOOT_TABLE_TEMPLATE = '''{
  "type": "minecraft:block",
  "pools": [
    {
      "bonus_rolls": 0.0,
      "entries": [
        {
          "type": "minecraft:item",
          "functions": [
            {
              "add": false,
              "conditions": [
                {
                  "block": "ds_random_stuff:oak_vertical_slab",
                  "condition": "minecraft:block_state_property",
                  "properties": {
                    "type": "double"
                  }
                }
              ],
              "count": 2.0,
              "function": "minecraft:set_count"
            },
            {
              "function": "minecraft:explosion_decay"
            }
          ],
          "name": "ds_random_stuff:oak_vertical_slab"
        }
      ],
      "rolls": 1.0
    }
  ]
}'''


def resolve_slab_resource(slab_file: str, filename: str):
    with open(slab_file) as io:
        slab_json = json.load(io)
    with open(f"assets/minecraft/blockstates/{filename}") as io:
        slab_blockstate_json = json.load(io)
    slab_json["parent"] = "ds_random_stuff:block/vertical_slab"

    with open("output/blockstates/" + filename.replace("slab", "vertical_slab"), "w") as io:
        io.write(BLOCK_STATE_TEMPLATE.replace("oak_vertical_slab", (filename[:-5]).replace("slab", "vertical_slab")).replace("minecraft:block/oak_planks", slab_blockstate_json["variants"]["type=double"]["model"]))

    with open("output/models/block/" + filename.replace("slab", "vertical_slab"), "w") as io:
        json.dump(slab_json, io)

    with open("output/models/item/" + filename.replace("slab", "vertical_slab"), "w") as io:
        item_model = dict()
        item_model["parent"] = "ds_random_stuff:block/" + (filename[:-5]).replace("slab", "vertical_slab")
        json.dump(item_model, io)

    with open("output/loot_tables/" + filename.replace("slab", "vertical_slab"), "w") as io:
        io.write(LOOT_TABLE_TEMPLATE.replace("oak_vertical_slab", (filename[:-5]).replace("slab", "vertical_slab")))


def resolve_assets():
    blockstates_dir = 'assets/minecraft/blockstates/'
    models_dir = 'assets/minecraft/models/'
    block_models_dir = f'{models_dir}block/'
    for model in os.listdir(block_models_dir):
        if model.endswith("_slab.json"):
            resolve_slab_resource(f"{block_models_dir}{model}", model)


def resolve_data():
    wooden_slabs = "./data/minecraft/tags/blocks/wooden_slabs.json"
    slabs = "./data/minecraft/tags/blocks/slabs.json"

    with open(wooden_slabs, "r") as wooden_slabs_io:
        wooden_slabs_json = json.load(wooden_slabs_io)
    with open(slabs, "r") as slabs_io:
        slabs_json = json.load(slabs_io)

    wooden_vertical_slabs = dict()
    vertical_slabs = dict()

    wooden_vertical_slabs_values = list()
    for v in wooden_slabs_json["values"]:
        wooden_vertical_slabs_values.append(v.replace("slab", "vertical_slab"))
    wooden_vertical_slabs["values"] = wooden_vertical_slabs_values

    vertical_slabs_values = list()
    for v in slabs_json["values"]:
        vertical_slabs_values.append(v.replace("slab", "vertical_slab"))
    vertical_slabs["values"] = vertical_slabs_values

    with open("./output/tags/wooden_vertical_slabs.json", "w") as wooden_slabs_io:
        json.dump(wooden_vertical_slabs, wooden_slabs_io)
    with open("./output/tags/vertical_slabs.json", "w") as slabs_io:
        json.dump(vertical_slabs, slabs_io)


def main():
    if not os.path.isdir("output"):
        os.mkdir("output")
    if not os.path.isdir("output/models"):
        os.mkdir("output/models")
    if not os.path.isdir("output/models/block"):
        os.mkdir("output/models/block")
    if not os.path.isdir("output/models/item"):
        os.mkdir("output/models/item")
    if not os.path.isdir("output/blockstates"):
        os.mkdir("output/blockstates")
    if not os.path.isdir("output/loot_tables"):
        os.mkdir("output/loot_tables")
    if not os.path.isdir("output/tags"):
        os.mkdir("output/tags")

    resolve_assets()
    resolve_data()


if __name__ == '__main__':
    main()

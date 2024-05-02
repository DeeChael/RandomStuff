import json


def main():
    with open("outer.json", "r") as io:
        names = json.load(io)
    for value in names["values"]:
        result = ""
        for split_part in value.split("_"):
            result += upperfirst(split_part) + " "
        print(result[:-1])


def upperfirst(value):
    mappings = {
        "a": "A",
        "b": "B",
        "c": "C",
        "d": "D",
        "e": "E",
        "f": "F",
        "g": "G",
        "h": "H",
        "i": "I",
        "j": "J",
        "k": "K",
        "l": "L",
        "m": "M",
        "n": "N",
        "o": "O",
        "p": "P",
        "q": "Q",
        "r": "R",
        "s": "S",
        "t": "T",
        "u": "U",
        "v": "V",
        "w": "W",
        "x": "X",
        "y": "Y",
        "z": "Z",
    }
    return mappings[value[0]] + value[1:] if (value[0] in mappings) else value


if __name__ == '__main__':
    main()

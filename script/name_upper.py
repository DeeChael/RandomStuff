import json

def main():
    with open("upper.json", "r") as io:
        names = json.load(io)
    for value in names["values"]:
        print(value.upper())


if __name__ == '__main__':
    main()

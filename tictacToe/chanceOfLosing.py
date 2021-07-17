from model import IsabellazThoughts
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("column", type=str, help="choose column form data set")
parser.add_argument("column2", type=str, help="choose column form data set")

args = parser.parse_args()

field = args.column2
f = args.column


total = IsabellazThoughts(f,field)
print(total)
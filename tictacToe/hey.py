#print("hey....i ran the python")
import sys, getopt
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("column", type=int, help="choose column form data set")
parser.add_argument("-v", "--verbosity", type=int, help="increase output verbosity")

args = parser.parse_args()
answer = args.column**2

def checkArg(arg):


if args.verbosity == 2:
    print("the square of {} equals {}".format(args.square, answer))
elif args.verbosity == 1:
    print("{}^2 == {}".format(args.square, answer))
else:
    print(args.column)
    print(answer)


#runEm(sys.argv[1:])
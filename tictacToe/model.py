import pandas as pd
import argparse

tictactoe = pd.read_csv('D:/javaWork/data/tic-tac-toe-endgame.csv', encoding = 'latin-1')

#print(tictactoe.describe())
#print(tictactoe.groupby('RESULT').size())

y = tictactoe['RESULT']
features = ['TL','TM','TR','ML','MM','MR','BL','BM','BR']

nom = pd.get_dummies(tictactoe[features], drop_first = True)
result = pd.get_dummies(y, drop_first = True)


parser = argparse.ArgumentParser()
parser.add_argument("column", type=str, help="choose column form data set")
parser.add_argument("column2", type=str, help="choose column form data set")

args = parser.parse_args()

field = args.column2

def IsabellazIdea(column):
    lst = tictactoe[column].to_list()
    resultList = tictactoe['RESULT'].to_list()

    combinedZip = zip(lst, resultList)
    positives = []

    for b, c in combinedZip:
        if (b == 'x')  and (c == 'positive'):
            positives.append(b)

    return len(positives)

def IsabellazThoughts(column, column2):
    lst = tictactoe[column].to_list()
    lst2 = tictactoe[column2].to_list()
    resultList = tictactoe['RESULT'].to_list()

    losses = []
    combinedZip = zip(lst, lst2, resultList)

    for i, c, d in combinedZip:
        if i == 'x' and d == 'negative':
            if c == 'o':
                losses.append(c)

    return len(losses)        
    
#losses = IsabellazThoughts('MM', 'BL')
#print(losses)

#for i in features:
#    total = IsabellazThoughts('TR', i)
#    print(total)


def checkArg(field):
    for i in features:
        total = IsabellazThoughts("ML",i)
        print(i,total)
    
   # print("..............................................")
    #for j in features:
     #   sums = IsabellazIdea(j)
      #  print(j, sums)


checkArg(field)

    
#print(len(trues))

#print(len(bmList))

#print(tictactoe.groupby('BM').size())
#print(type(tictactoe.shape))



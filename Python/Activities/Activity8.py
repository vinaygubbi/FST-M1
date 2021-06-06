numbers = list(input("Enter the list of numbers: ").split(','))

firstNum = numbers[0]
lastNum = numbers[-1]

if (firstNum == lastNum):
    print(True)
else:
    print(False)
    
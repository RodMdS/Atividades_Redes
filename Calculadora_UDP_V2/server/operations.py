def add(op1, op2):
    try:
        return float(op1) + float(op2)
    except ValueError:
        return "Error: the message isn't correct"

def sub(op1, op2):
    try:
        return float(op1) - float(op2)
    except ValueError:
        return "Error: the message isn't correct"

def mpy(op1, op2):
    try:
        return float(op1) * float(op2)
    except ValueError:
        return "Error: the message isn't correct"

def div(op1, op2):
    try:
        return float(op1) / float(op2)
    except ValueError:
        return "Error: the message isn't correct"
    except ZeroDivisionError:
        return "Error: division by zero"

def pot(op, exp):
    try:
        return float(op) ** float(exp)
    except ValueError:
        return "Error: the message isn't correct"

def sqrt(op):
    try:
        return float(op) ** (0.5)
    except ValueError:
        return "Error: the message isn't correct"

def mod(op1, op2):
    try:
        return int(op1) % int(op2)
    except ValueError:
        return "Error: the message isn't correct"

import operations

def calcular(msg):
    #default message is "<metodo> <op1> <op2>"
    campos = msg.split(" ")
    if campos[0] == "add":
        try:
            resp = operations.add(campos[1], campos[2])
        except IndexError:
            resp = "Error: the message isn't correct"
        pass
    elif campos[0] == "sub":
        try:
            resp = operations.sub(campos[1], campos[2])
        except IndexError:
            resp = "Error: the message isn't correct"
        pass
    elif campos[0] == "mpy":
        try:
            resp = operations.mpy(campos[1], campos[2])
        except IndexError:
            resp = "Error: the message isn't correct"
        pass
    elif campos[0] == "div":
        try:
            resp = operations.div(campos[1], campos[2])
        except IndexError:
            resp = "Error: the message isn't correct"
        pass
    elif campos[0] == "pot":
        try:
            resp = operations.pot(campos[1], campos[2])
        except IndexError:
            resp = "Error: the message isn't correct"
        pass
    elif campos[0] == "mod":
        try:
            resp = operations.mod(campos[1], campos[2])
        except IndexError:
            resp = "Error: the message isn't correct"
        pass
    elif campos[0] == "sqrt":
        try:
            resp = operations.sqrt(campos[1])
        except IndexError:
            resp = "Error: the message isn't correct"
        pass
    else:
        resp = "Error: informed method unknown"
        pass
    return resp
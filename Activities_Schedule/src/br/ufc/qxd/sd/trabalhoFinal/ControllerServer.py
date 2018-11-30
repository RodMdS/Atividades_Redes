import sys
import json
import ActivityController as controller
import Activity as activity

controller = controller.ActivityController()

def defineOperation(request):
    # leio o objeto request que está em json e transformo em um objeto chave-valor
    message = json.loads(request)
    if message["op"] == "list": # aí consigo acessar assim os dados do json
        return json.dumps([activity.__dict__ for activity in controller.getActivities()])
    elif message["op"] == "add":
        newActivity = activity.Activity(message["title"], message["description"], message["closingDate"])
        controller.addActivity(newActivity)
    elif message["op"] == "up":
        newActivity = activity.Activity(message["title"], message["description"], message["closingDate"])
        controller.updateActivity(int(message["id"]), newActivity)
    elif message["op"] == "end":
        controller.finishActivity(int(message["id"]))
    # transformo meus objetos em json novamente com esse método dumps
    return json.dumps([activity.__dict__ for activity in controller.getActivities()])
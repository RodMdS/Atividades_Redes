import datetime

class ActivityController():
    
    def __init__(self):
        self.activities = []

    def addActivity(self, activity):
        self.activities.append(activity)

    def updateActivity(self, id, activity):
        for i in self.activities:
            if i.id == id:
                i.title = activity.title
                i.description = activity.description
                i.closingDate = activity.closingDate
                i.status = "FAZER"

    def getActivityById(self, activityId):
        for i in self.activities:
            if i.id == activityId:
                return i
        return None
    
    def rmActivityByID(self, activityId):
        activity = self.getActivityById(activityId)
        self.activities.remove(activity)
    
    def getActivities(self):
        self.updateStatusActivities()
        self.activities.sort(key=lambda a: datetime.datetime.strptime(a.closingDate, "%d/%m/%y"))
        return self.activities
    
    def finishActivity(self, activityId):
        self.rmActivityByID(activityId)
    
    def updateStatusActivities(self):
        for i in self.activities:
            if datetime.datetime.strptime(i.closingDate, "%d/%m/%y") < datetime.datetime.now():
                i.status = "ATRASADA"
class Activity():
    COUNT = 0

    def __init__(self, title, description, closingDate):
        Activity.COUNT += 1
        self.id = Activity.COUNT
        self.title = title
        self.description = description
        self.status = "FAZER"
        self.closingDate = closingDate

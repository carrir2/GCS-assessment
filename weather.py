import requests

# list of favorite cities
favorites = []

def main():
    while True:

        #Displays list of commands
        print('''\n\nCoding Activity 1 - Making API Calls \nCommands: 
        search: Searches and displays current weather details of city
        list: Displays list of favorited cities and their current weather details.
        add: Adds city to list of favorites. (max: 3)
        remove : Removes a city from list of favorites.''')

        command = input("Enter command:\n").lower()         #Input of command
        
        if command == "search":                             #Command handler
            city = input("Enter City:\n")                   #Input of City
            search(city)
        elif command == "list":
            listCmd()
        elif command == "add":
            add()
        elif command == "remove":
            remove()



def search(city):
    #URL of API endpoint
    url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=imperial&appid=cbc0083d1eb6eff7280a407cafc3d662"
    response = requests.get(url)                                #GET request to API.
    respJson = response.json()
    if (respJson["cod"]==200):                                  #Status code hander, success if status code is 200.
        #Displays City, Current tempearture, and Weather Description
        print("\n%s: %2d°F, %s" % (city, respJson["main"]["temp"], respJson["weather"][0]["main"]))
    else:                           #Error handler.
        #Displays City and Error message
        print("\n%s: Error, %s" % (city, respJson["message"]))


def listCmd():
    #Checks if list is not empty
    if len(favorites)!=0:
        for city in favorites:                                  #Loops through cities in favorites list and uses search function 
            search(city)                                        #to display current temperatures.
    else:
        print("\nFavorites List is empty.")                     #Displays message that list is empty.

def add():
    #Checks if list is full.
    if len(favorites) < 3:
        cityFav = input("Enter city to add to favorites:\n")    #Input of City

        if cityFav in favorites:                                #Checks if city is already in list.
            print("%s is already in favorites." % (cityFav))
            return
        
        favorites.append(cityFav)                               #Adds city to list and displays message.
        print("%s has been added to favorites." % (cityFav))
    else:
        print("\nYou have reached max limit of list. (3)")      #Displays message on max limit.

def remove():
    if len(favorites)==0:                                       #Checks if favorites is empty and then displays message
        print("List is empty.")
        return
    cityOld = input("Enter city to remove from favorites:\n")   #Input of City
    if cityOld in favorites:                                    #Checks if city is in list and removes from list
        favorites.remove(cityOld)
        print(cityOld+" has been removed.")
    else:                                                       #If not in list, displays that city is not found.
        print(cityOld+" not found.")

main()
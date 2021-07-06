All command inputs can have the first letter capitalized, many will recognize the command with only one letter.
When entering a country the first letter must be capitalized.

The user can enter muliple words of a command at one time, ex. generate 50, or enter each one word per line.

Program will start with asking the user if they want to import or generate data. If the user selects 
generate they must then type the number of lines to generate. If they chose to import they must type the
exact filename including the file type. After either of these the user can enter a variety of commands,
the main ones being: Sort, Find/Get, Clear, Export, Print, and Exit, as well as the option to generate or
import again.

Generate creates new data, pulling from txt files with example names and countries.
The number of lines is decided by the user.
The names were gotten from https://github.com/smashew/NameDatabases
Countries from https://gist.github.com/kalinchernev/486393efcca01623b18d

ex. 	Generate 500
	g 50

Import will pull data from a file. The file must be in NDJSON format, similar to that of example.txt.
The user will need to enter the file name.

ex. 	Import example.txt
	i example2.txt

Sort allows the user to sort the list by Age, Name or Country. The user must select one and then the order
eg. youngest to oldest, oldest to youngest, alphabetically or reverse alphabetically. If the order isn't
understood it defaults to youngest to oldest for age and alphabetical for country/name.

ex. 	Sort Age Old
	s n r

Find/Get allows the user to query the list for several things. First the user can find the oldest or youngest in the list.
Next it can take a country and print the age groups in said country. 
Finally it can print each country followed by the number in the country.

ex.	Find Oldest
	get young
	f age New Zealand
	g c

Clear empties the lists. Not much use as generate and import both make new lists.

ex.	Clear
	c

Exit simply stops the program. 

ex. 	Exit
	exit

Export outputs the data to a new text file with the name given by the user.

ex. 	Export file
	export name

Print simply prints the data in its entirety 

ex.	Print
	p
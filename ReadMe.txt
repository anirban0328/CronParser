Cron Expression Parser:
A java command line application that parses the input cron expression and prints the complete datatime for each of the fields, along with the command field.

Usage:
$ java -jar cronparser.jar "*/15 0 1,15 * 1-5 /usr/bin/find"

Input:
*/15 0 1,15 * 1-5 /usr/bin/find

Output:
minute        0 15 30 45 
hour          0 
day of month  1 15 
month         1 2 3 4 5 6 7 8 9 10 11 12 
day of week   1 2 3 4 5 
command       /usr/bin/find

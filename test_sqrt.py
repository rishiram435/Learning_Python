import math
#function print the square root of integer by newton's method
def my_sqrt(a):
    #Calling Error if value less than 0
    if a<0:
        raise ValueError('Square root not defined for negative number')
    x = int(a)
    if x == 0:
        return 0
    #Compute to get the value necessary to find square root 
    y, z = divmod(x.bit_length(), 2)
    a = 2**(y+z)
    #while loop to run the newton method until y>=a
    while True:
        y= (a+ x/a)/2
        if y>=a:
            return a
        a=y
        
#Function that print square root from 1 to 25 and compute difference between manual function(my_sqrt) and in-built-function(math.sqrt)           
def test_sqrt(a):
        while a<26:
            print('a=',a,'|',end='')#To print the line without creating new line
            print("my_sqrt(a)=",my_sqrt(a),'|',end='')
            print('math.sqrt(a)=',math.sqrt(a),'|',end='')
            print('diff=',abs(my_sqrt(a)-math.sqrt(a)))
            a=a+1

test_sqrt(1)







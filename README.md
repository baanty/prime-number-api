## prime-number-api

The project calculates prime numbers till a limit. The input must be in the URL form http://www.myhost.com/10?mediaType=json&algorithm=SUNDARAM_SIEVE
Points to keep in mind when accessing the API are,

#### There are two http parameters
    1) mediaType : It denotes the expected returned mediatype. Currently we support 'XML' and 'JSON'. Infuture development iterations
                   we shall also support text, html etc. If no header mediatype parameter is mentioned, then a JSON will be returned.
    2) algorithm : It denotes the algorithm you want to calculate the list of prime numbers. Currenlty we support three algorithms. 
                    So, the user can pass three values. These values are BRUTE_FORCE, ERATOSTHENES_SIEVE and SUNDARAM_SIEVE. 
                    All these algorithms have their computation cost. The user must pass a value of the algorithm parameter
                    from the above allowed values list. If no value is given, then the BRUTE_FORCE algorithm will be used by
                    default.
                    
                    
                    
#### Securing the application 
The API is now secured by basic authentication of user id and password. The default user id is 'admin' . The
password for admin is 'password'.
       


    
                  
          
            0

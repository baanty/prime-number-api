## prime-number-api

The project calculates prime numbers till a limit. The input must be in the URL form http://prime-git.herokuapp.com/primes/10?algorithm=SUNDARAM_SIEVE.
The API is currently deployed at the above URL. In tis case, the numeric '10' is a placeholder of the input number.

Points to keep in mind when accessing the API are,

#### There ia an http header
    media-type : It denotes the expected returned media type. Currently we support 'XML' and 'JSON'. Infuture development iterations
                   we shall also support text, html etc. If no header media-type is mentioned, then a JSON will be returned.
                   Currently allowed values - 
                   **XML
                   'JSON'**
                   
#### There ia an http url parameter
    algorithm : It denotes the algorithm you want to calculate the list of prime numbers. Currenlty we support three algorithms. 
                    So, the user can pass three values. These values are BRUTE_FORCE, ERATOSTHENES_SIEVE and SUNDARAM_SIEVE. 
                    All these algorithms have their computation cost. The user must pass a value of the algorithm parameter
                    from the above allowed values list. If no value is given, then the BRUTE_FORCE algorithm will be used by
                    default. If an invalid value is give, then also the BRUTE_FORCE algorithm will be used.
                    Currently allowed values - 
                    **BRUTE_FORCE
                    ERATOSTHENES_SIEVE
                    SUNDARAM_SIEVE**
                    
                    
#### Securing the application 
The API is now secured by basic authentication of user id and password. The default user id is 'admin' . The
password for admin is 'password'.
       


    
                  
          
            0

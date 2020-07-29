자료형(Data Type)
===============
 * 자료형 - 기본형(Primitive Type), 참조형(Reference Type)
 * 기본형 자료형 - 정수형, 실수형, 문자형, 논리형
 * 참조형 자료형 - 문자열(String)
##기본형 자료형
###정수형
+ 정수형 종류
    * byte <br>
    크기 : 1바이트(8bit) <br>
    범위 : -2^7 ~ 2^7-1 <br>

    * short <br>
    크기 : 2바이트(16bit) <br>
    범위 : -2^15 ~ 2^15-1 <br>

    * int <br>
    크기 : 4바이트(32bit)<br>
    범위 : -2^31 ~ 2^31-1<br>
    *정수형은 기본적으로 int*

    * long <br>
    크기 : 8바이트(64bit) <br>
    범위 : -2^63~ 2^63-1 <br>
        * long veryBigInt = 10000000000000L; <br>
            long형 선언 시 리터럴 뒤에 L or l
           
                                                                         
                                       
                                                                        

+ 오버플로우 발생 경우
```
short shortValue = (short)64000;
byte byteValue3 =  144;
int bigInt = Integer.MAX_VALUE;
int biggerInt = bigInt + 1; 
```
        


+ 진수법
    * Binary(2) -> 앞에 0b
    * Octal(8) -> 앞에 0
    * Decimal(10)
    * Hexadecimal(16) -> 앞에 0x
###실수형

###문자형
###논리형
###문자열









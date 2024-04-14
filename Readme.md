<h1>Crypto Analyzer:</h1>

EN:

<h3>Desription:</h3>

This application encrypts and decrypts data using Caeser cypher.

Functional scope:
1. Encrypt data
2. Decrypt data
3. Decrypt data with brute-force method
4. Decrypt data with statistic analyze method

How it works:

1. The user creates a file that needs to be encrypted and enters the necessary data into this file.
2. Selects the "Encode" mod and point on the file with data and in second parameter point on file that must be save encrypted data.
3. The third parameter is responsible for the encoding key
4. After confirming the encoding of the file, all encrypted data is saved to the file specified by the second parameter.

Special features:

1. BruteForce method - the application decrypts the encoded text using the brute force method. In order for the method to work correctly, you need to create a file with other data from the same author or just a list of words or characters that may be in the encrypted text. *Important - all words or characters must be listed on a new line, example:

hello -> 1 line in the file<br>
world -> 2 lines in the file

2. The StatisticAnalyze method - the application decrypts data based on the frequency analysis of symbols, in order for this mod to work correctly, you also need to specify a file with other data from this author, you can save data to this file in any form without observing other rules.

RUS:

<h3>Описание:</h3>

Это приложение шифрует и дешифрует любые данные с применением шифра цезаря.

Функциональные возможности:

1. Шифровать данные
2. Дешифровать данные
3. Дешифровать данные с помощью brute-force метода
4. Дешифровать данные с помощью метода статистического анализа

Как работает приложение:

1. Пользователь создает файл с данными, которые нужно закодировать.
2. Запускает программу из папки с этим файлом
3. Выбирает мод(в этом случае Encode) -> т.е. вводит цифру "1".
4. Далее ему предлагается ввести первым параметром название файла, который будет выступать в роли файла с данными, которые нужно шифровать.
5. Затем, через пробел, вторым параметром предлагается ввести название файла, в котором будут зашифрованные данные(если он не создан - создатся автоматически).
6. Третий параметр также вводится через пробел и он отвечает за ключ шифрования, количество символов, на которые будут сдвинуты данные при шифровании.

Специальные возможности:

1. Метод BruteForce - приложение расшифровывает закодированный текст с помощью метода перебора. Для того, чтобы метод работал правильно нужно создать файл с другими данными того же автора или просто перечислением слов или символов, которые могут быть в зашифрованном тексте. <span style="color:red">*Важно</span> - все слова или символы должны быть перечислены с новой строки, пример: 

hello -> 1 строка в файле<br>
world -> 2 строка в файле

2. Метод StatisticAnalyze - приложение дешифрует данные на основе частотного анализа символов, для того, чтобы этот мод работал правильно нужно также указывать файл с другими данными этого автора, сохранять в этот файл данные можно в любом виде без соблюдения других правил. <span style="color:red">*Важно</span> статитистический анализ может не дать точную расшифровку для больших текстов. Он дает заготовку для дальнейшей дешифровки вручную.
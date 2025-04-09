
# Introducing I/O Streams

The java.io API defines two sets of I/O stream classes for reading and writing I/o streams:
byte I/O streams and character I/O stream.

- Byte I/O streams read/write binary data (0s and 1s) and have class names that end in InputStream or OutputStream.
- Character I/O streams read/write text data and have class names that end in Reader or Writer

The I/O streams are primarily used to work with binary data, such as an image or 
executable file, while character I/O streams are used to work with text files. (page 813)

# 📌 O que é Character Encoding?
Character encoding (codificação de caracteres) é um sistema que mapeia caracteres para valores numéricos (bytes) para serem armazenados e processados em computadores.

Cada encoding define como caracteres (letras, números e símbolos) são representados em binário (0s e 1s). 
Se a codificação errada for usada, os caracteres podem aparecer corrompidos (ex.: "ç" virar "?").

### 1️⃣ Tipos de Character Encoding em Java
🏆 Principais Codificações:
- ASCII	7 bits	Suporta apenas caracteres básicos (A-Z, a-z, 0-9, símbolos)	Arquivos antigos, comunicação serial
- ISO-8859-1 (Latin-1)	8 bits	Suporta caracteres especiais usados na Europa Ocidental, como "ç", "á"	Arquivos em português, espanhol, francês
- UTF-8	1 a 4 bytes	Suporta todos os caracteres do Unicode (universal)	Padrão para web, JSON, APIs, Java moderno
- UTF-16	2 ou 4 bytes	Ideal para textos asiáticos, usa mais espaço	Softwares que manipulam texto intensivamente
- UTF-32	4 bytes	Cada caractere ocupa exatamente 4 bytes	Pouco usado por ser ineficiente em espaço
⚠️ Observação:
O UTF-8 é o mais recomendado atualmente, pois é compacto e compatível com praticamente todos os sistemas.

### 2️⃣ Para que serve o Encoding?
A codificação é usada para garantir que os caracteres sejam exibidos corretamente ao:
- ✅ Salvar e ler arquivos de texto
- ✅ Processar strings em programas Java
- ✅ Transmitir dados pela internet (HTML, JSON, APIs)
- ✅ Trabalhar com bancos de dados

Exemplo de problema de encoding:

Um arquivo salvo em ISO-8859-1 e lido como UTF-8 pode mostrar caracteres errados, como "Jo?o" ao invés de "João"
###  3️⃣ Em que países foram criados os Encodings?
- ASCII	/ EUA / American National Standards Institute (ANSI) 1963
- ISO-8859-1 / Europa / International Organization for Standardization (ISO) 1987
- (UTF-8 / UTF-16 / UTF-32)	/ Internacional	Consórcio Unicode 1993
###  4️⃣ Qual Encoding é usado no Brasil?
No Brasil, os encodings mais comuns são:
- ✅ ISO-8859-1 (Latin-1) → Usado em sistemas mais antigos, pois inclui acentos e "ç"
- ✅ UTF-8 → Padrão atual para a maioria dos sistemas, pois suporta todos os caracteres do português

#### ⚠️ Evite usar ISO-8859-1 em sistemas modernos, pois ele não suporta caracteres de outros idiomas e pode causar problemas de compatibilidade.

### ✅ Resumo
- Character Encoding converte caracteres em bytes para armazenamento e transmissão.
- UTF-8 é o padrão mais usado no Brasil e no mundo.
- ISO-8859-1 foi usado no passado, mas hoje é obsoleto.
- Java permite definir encoding ao ler e escrever arquivos para evitar problemas de compatibilidade.

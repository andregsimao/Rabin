#!/usr/bin/env python

"""rabin.py: Algoritmo para criptografia e decriptografia de mensagem pelo metodo de Rabin"""

__author__  = "Andre Simao, Felipe Tuyama, Marco Aurelio Prado and Matheus Leao"
__credits__ = ["Andre Simao", "Felipe Tuyama", "Marco Aurelio Prado",
                    "Matheus Leao"]
__email__   = "leaomatheus11@gmail.com"

# Printar um inteiro em binario
def print_bits(value):
	string = ""
	while value > 0:
		string = string + str(value%2)
		value /= 2
	print(string[::-1])

# Converter um inteiro para a string correspondente utilizando a tabela ASCII
def to_str(value, alphabet_size):
	string = ""
	while value > 0:
		string = string + chr(value%alphabet_size)
		value /= alphabet_size
	return string

# Checando se a redundancia existe
def check_redundancy(value, redundancy):
	extraBits = value & ((1 << redundancy) - 1)
	value >>= redundancy
	checkBits = value & ((1 << redundancy) - 1)
	return extraBits == checkBits

# Algoritmo de euclides estendido
def extended_euclides(p, q):
	if p == 0:
		return 0, 1
	x1, y1 = extended_euclides(q%p, p)
	x = y1 - (q/p)*x1
	y = x1
	return x, y

# Potencia 'a' elevado a 'p' modulo 'n'
def modpot(a, p, n):
	ret = 1
	while p > 0:
		if (p & 1):
			ret = (ret*a) % n;
		p = p >> 1
		a = (a*a)%n
	return ret

def main():
	## Usando o valor correspondente da tabela ASCII para cada caractere
	alphabet_size = 256

	## Chaves privadas
	_p = 492876863
	_q = 492876847
	## Chave publica
	n = _p*_q
	## Redundancia desejada (em bits)
	redundancy = 4

	######## Criptografando a mensagem ########
	message = "mesge"
	## Convertendo a mensagem para valor da tabela ascii
	messageValue = 0
	i = 1
	for caractere in message:
		messageValue += i*ord(caractere)
		i *= alphabet_size

	## Adicionando redundancia (trabalhando com bits, checando divisoes por 2)
	extraBits = messageValue & ((1 << redundancy) - 1)
	messageValue <<= redundancy
	messageValue += extraBits

	c = (messageValue*messageValue)%n

	######## Decriptografando a mensagem ##########
	print('Decripting')
	
	## Resolvendo a equacao xp + yq = 1 pelo algoritmo de Euclides estendido
	x, y = extended_euclides(_p, _q)
	r = modpot(c, (_p+1)/4, _p)
	s = modpot(c, (_q+1)/4, _q)

	valid = []

	ansA = (x*_p*s + y*_q*r)%n
	## Checando redundancia
	if check_redundancy(ansA, redundancy):
		valid.append(to_str(ansA >> redundancy, alphabet_size))
	
	ansB = (x*_p*s - y*_q*r)%n
	if check_redundancy(ansB, redundancy):
		valid.append(to_str(ansB >> redundancy, alphabet_size))
		
	ansC = -ansA%n
	if check_redundancy(ansC, redundancy):
		valid.append(to_str(ansC >> redundancy, alphabet_size))
	
	ansD = -ansB%n
	if check_redundancy(ansD, redundancy):
		valid.append(to_str(ansD >> redundancy, alphabet_size))
	
	for string in valid:
		print(string)

if __name__ == "__main__":
	main()
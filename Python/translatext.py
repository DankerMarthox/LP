import re
import sys

### Se abre el archivo desde el que se va a leer, y se guardan todas las lineas del texto en la variable "archivo"

file = open("pseudocode.txt", "r")
archivo = file.readlines()
file.close()

programas = []

### Se crea el archivo de salida, donde se guardará el resultado final de la ejecución del programa
Salida = open("pseudocodigo.txt", "w")

### Se revisa el caso en el que el archivo esté vacío
if len(archivo) == 0:
    Salida.write("********************\nNo hay Programa\n********************")
    Salida.close()
    ### En este caso, se cierra el archivo y se cancela la ejecución del programa
    sys.exit()

### En caso contrario, se continúa con el resto del programa
archivo[-1] = archivo[-1].strip()
archivo = "".join(archivo)
### Estas 2 lineas eliminan el "\n" del final del archivo, el cual se genera a veces, y otras no
### pero que resultaba en que al final del archivo hubiese un "#Error" como última linea


textlist = archivo.split("\n")
archivo = archivo.split("\n")

### Se separa el archivo en una lista donde cada elemento es una linea

i = 0
while i < len(archivo):
    archivo[i] += " #Error"
    i += 1
archivo = "\n".join(archivo)
archivo2 = archivo

"""
####################################################################################################################################
A cada linea guardada en "archivo" se le agrega un "#Error" al final, por lo que hasta el momento se tienen 2 copias del archivo:
    archivo: contiene cada una de las lineas, con el error señalado al final
    textlist: contiene cada linea, pero, en este caso, no tiene los errores señalados
¿Por qué?: Es más facil revisar los casos correctos que revisar los incorrectos y marcarlos por separado, por lo que se asume el archivo
            como que todo está incorrecto, y, se revisará cada linea para verificar si está correcta.
            En caso de que esté correcta, se reemplazará la linea marcada por la sin marcar, que, a su vez, será traducida.
####################################################################################################################################
"""


################################################################################
##### Diccionarios con los comandos propios del lenguaje ##############
################################################################################

### Este diccionario posee cada uno de los comandos con su correspondiente traducción
commandDic = {  "SET":          "FIJAR",
                "INITIALIZE":   "INICIALIZA",
                "SUBTRACT":     "RESTA",
                "SUM":          "SUMA",
                "MULTIPLY":     "MULTIPLICA",
                "DIVIDE":       "DIVIDE",
                "AND":          "Y",
                "OR":           "O",
                "NO":           "NO",
                "EQUAL":        "IGUAL",
                "TO":           "A",
                "DIFFERENT":    "DIFERENTE",
                "GREATER":      "MAYOR",
                "SMALLER":      "MENOR",
                "THAN":         "QUE",
                "IF":           "SI",
                "THEN":         "ENTONCES",
                "ELSE":         "SINO",
                "END":          "FIN",
                "READ":         "LEER",
                "PRINT":        "IMPRIME",
                "BY":           "POR",
                "PROCEDURE":    "PROCEDIMIENTO"
            }
            # WHILE Y END WHILE SE TRADUCEN POR SEPARADO


### Este diccionario tiene cada comando con el "Tipo" de cada comando (El tipo corresponde a la seccion del PDF en la
### que está definido

### ¿Por qué ambos diccionarios no están juntos? Porque no son iguales, ded.
### Y tambien, porque es más bonito así. Mas facil usar cada diccionario según
### lo que se necesite que usar uno solo que tenga tuplas, (donde algunos elementos ni si quiera existen)

commandType = { "SET":          "4.2",
                "INITIALIZE":   "4.2",
                "SUBTRACT":     "4.3.1",
                "SUM":          "4.3.1",
                "MULTIPLY":     "4.3.1",
                "DIVIDE":       "4.3.1",
                "AND":          "4.3.2",
                "OR":           "4.3.2",
                "NO":           "4.3.2",
                "EQUAL":        "4.3.2",
                "DIFFERENT":    "4.3.2",
                "GREATER":      "4.3.2",
                "SMALLER":      "4.3.2",
                "READ":         "4.6",
                "PRINT":        "4.6",
            }


lista432 = ["AND", "OR", "EQUAL", "DIFFERENT"]
### Esta es una lista con los comandos que pertenecen al grupo 4.3.2 y que manejan los parametros de una forma distinta al
### resto, entonces tenerlos aquí agrupados sirve para organizar mejor una parte del programa (Ya se verá)


#######################################################################################################
#######################################################################################################

### Esta funcion recibe una linea CORRECTA, y traduce cada uno de sus segmentos, según corresponda
### Retorna la linea traducida

def traducirSentencia(linea):

### Los casos que se encuentran separados por "if" o "elif" son casos especiales
### Como el caso de "WHILE", que se puede traducir en "MIENTRAS" o "MIENTRAS QUE" según sea su contexto

    if len(re.findall(r"^\s*END\s+WHILE\s*$", linea)) != 0:
        return ("MIENTRAS".join(("FIN".join(linea.split("END"))).split("WHILE")))

    elif len(re.findall(r"^\s*WHILE\s+[^$]*$", linea)) != 0:
        linea = "MIENTRAS QUE".join(linea.split("WHILE"))

    elif len(re.findall(r"^\s*IF[^$]*$", linea)) != 0:
        linea = ("SI".join(linea.split("IF")))

    elif len(re.findall(r"^\s*ELSE\s*$", linea)) != 0:
        linea = ("SINO".join(linea.split("ELSE")))

    elif len(re.findall(r"^\s*END\s*IF\s*$", linea)) != 0:
        linea = ("FIN".join(linea.split("END")))
        linea = ("SI".join(linea.split("IF")))

    elif len(re.findall(r"^\s*SET\s+\w+\s+TO\s+[^$]*$", linea)) == 1:
        linea = linea.split(" ")
        index = 0
        while index < len(linea):
            if linea[index] == "SET":
                linea[index] = "FIJAR"
            elif linea[index] == "TO":
                linea[index] = "EN"
                linea = " ".join(linea)
                break
            index += 1

    linea = linea.split(" ")
    index = 0

### Por ultimo, una vez que ya se revisaron los casos particulares, se analiza el comando palabra por palabra,
### donde cada palabra recibe la traduccion correspondiente, y, finalmente, la retorna.
    while index < len(linea):
        if linea[index] in commandDic:
            linea[index] = commandDic[linea[index]]
        index += 1
    return " ".join(linea)




### Esta funcion recibe 3 listas, las cuales contienen los indices de las lineas que poseen comandos segun corresponde a cada lista
### A partir de esto realiza una evaluacion de estas listas para encontrar cuales comandos estan asociados con cuales, según sea correcto
def checkList(If, Else, End):
    I1 = If[:]
    I2 = If[:]
    I3 = If[:]
    e1 = If[:]
    e2 = If[:]
    e3 = Else[:]
    en1 = If[:]
    en2 = If[:]
    en3 = End[:]

    first = checkIfs(I1, e1, en1, False, False)
    second = checkIfs(I2, e2, en2, True, False)

    if first >= second:
        checkIfs(I3, e3, en3, False, True)
    else:
        checkIfs(I3, e3, en3, True, True)





### Esta funcion es la que realiza la revision de las listas para saber cuales son los ifs correctos.
### Los parametros que recibe son las 3 listas con los indices, y, además recibe 2 parametros adicionales
### Estos son:
    ### Reverse: Como se ve en la linea 203, se realiza una revision de este parametro. Si es "True", se invierte la lista
    ###          en el caso contrario, no se invierte
    ###
    ### Override: Cuando es Verdadero puede reemplazar lineas del archivo final, si es falso solo se utiliza como contador.
### Esta funcion retorna un contador de cuantas cadenas de IF hay correctas en el programa.


def checkIfs(If, Else, End, Reverse, Override):
    Cantidad = 0
    if len(If) != 0 and len(Else) != 0 and len(End) != 0:
        iterNo = min(len(If), len(Else), len(End))
        if Reverse:
            If.reverse()
        COUNT = 0

        for i in If:
            index = i+1
            if COUNT < iterNo:
                ifFlag = endFlag = elseFlag = False
                indexElse = indexEnd = 0
                for indEnd in End:
                    if indEnd > index:
                        endFlag = True
                        indexEnd = indEnd
                        End.remove(indexEnd)
                        break
                for indElse in Else:
                    if indElse > index and indElse < indexEnd:
                        elseFlag = True
                        indexElse = indElse
                        Else.remove(indexElse)
                        break

                if elseFlag and endFlag and indexEnd > indexElse :
                    Cantidad += 1
                    if Override:
                        archivo[i] = traducirSentencia(textlist[i])
                        archivo[indexElse] = traducirSentencia(textlist[indexElse])
                        archivo[indexEnd] = traducirSentencia(textlist[indexEnd])

            COUNT += 1
    return Cantidad

####################################################################################################
####################################################################################################

### Esta funcion analiza el caso de los "WHILE".
### Recibe una linea que posee "WHILE" en su comienzo, revisa que el caso sea correcto, y, de serlo, comienza a recorrer
### el archivo hasta encontrar un "END WHILE", cuando lo hace, o, si no lo logra, retorna el indice de la ultima linea revisada, donde
### la revisión continuará desde el Main

def indexCiclo(linea, indice, inCondicional, lastIndex):

    lineWhile = linea
    lineWhile = lineWhile.split("WHILE", 1)
    lineWhile = "".join(lineWhile)

    If = []
    Else = []
    End = []

    if not isValid(lineWhile, "4.3.2"):
        return indice+1

    indexWhile = indice
    indice += 1
    while indice < lastIndex:

        if isValid(textlist[indice], "4.3"):
            archivo[indice] = traducirSentencia(textlist[indice])
        elif isValid(textlist[indice], "4.2"):
            archivo[indice] = traducirSentencia(textlist[indice])
        elif isValid(textlist[indice], "4.6"):
            archivo[indice] = traducirSentencia(textlist[indice])

        if len(re.findall(r"^\s*END\s+WHILE\s*$", textlist[indice])) == 1:
            if indice > (indexWhile+1):
                archivo[indexWhile] = traducirSentencia(textlist[indexWhile])
                archivo[indice] = traducirSentencia(textlist[indice])
                return indice
            else:
                return indice+1

        elif len(re.findall(r"^\s*IF\s+[^$]*$", textlist[indice])) == 1:
            if isCondicional(textlist[indice], indice):
                If.append(indice)

        elif len(re.findall(r"^\s*ELSE\s*$", textlist[indice])) == 1:
            Else.append(indice)

        elif len(re.findall(r"^\s*END\s+IF\s*$", textlist[indice])) == 1:
            End.append(indice)

        elif len(re.findall(r"^\s*WHILE\s+[^$]*$", textlist[indice])) == 1:
            indice = indexCiclo(textlist[indice], indice, False, lastIndex)
            if indice >= len(textlist):
                break

        indice += 1

    checkList(If, Else, End)
    return indice


##################################################################################################
##################################################################################################

### Esta funcion revisa que una linea especifica sea el inicio de un condicional, con lo que retorna
### True o False según sea el caso

def isCondicional(linea, indice):

    #print(linea)

    if "IF" in linea and "THEN" in linea:

        linea = "".join(linea.split("IF", 1))
        linea = linea.split("THEN", 1)
        linea = [x for x in linea if x != '']
        linea = [x for x in linea if x != ' ']

        for x in linea:
            if x == "IF" or x == "THEN":
     #           print("FALSE")
                return False

        linea = "".join(linea)

        if isValid(linea, "4.3.2"):
      #<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<      print("TRUE")
            return True

    else:
        return False


#######################################################################################
#######################################################################################

### Esta funcion revisa que la linea recibida como parametro corresponda solamente a una "Variable", ya sea, un
### numero, nombre de variable, string, etc... y, que, a la vez, NO sea una palabra reservada del lenguaje

def isVariable(linea):

    if len(re.findall(r"^\s*ELSE\s*$", linea)) == 1:
        return False

    Verificacion = "".join(linea.split(" "))
    if (Verificacion in commandDic) or (Verificacion in ["WHILE", "ENDWHILE"]):
        return False

    elif len(re.findall(r"^\s*['].+[']\s*$", linea)) == 1 or len(re.findall(r'^\s*["].+["]\s*$', linea)) == 1:
        return True
        # String

    elif len(re.findall(r'^\s*True\s*$', linea)) == 1 or len(re.findall(r'^\s*False\s*$', linea)) == 1:
        return True
        # Bool

    elif len(re.findall(r"^\s*\d+\s*$", linea)) == 1:
        return True
        # Int

    elif len(re.findall(r"^\s*\d+[.]\d+\s*$", linea)) == 1:
        return True
        # Float

    elif len(re.findall(r"^\s*[a-zA-Z]\w*\s*$", linea)) == 1:
        return True
        # Variable

    else:
        return False




### Revisa de forma recursiva cada uno de los comandos que forman parte de una linea, para esto, recibe un string que es la linea que está revisando en el momento,
### y, a parte de esto, recibe un "Tipo" el cual corresponde al tipo de los parametros que puede aceptar, esto debido a que ciertos comandos aceptan
### otros especificos como pate de sus parametros, por lo que se debe separar entre cuales acepta y cuales no.
### Estos tipos se encuentran especificados en los diccionarios y en las instrucciones en pdf.
### Retorna correcto a medida que las expresiones estén bien planteadas, si no, retorna false.

def isValid(linea, tipo):

    if isVariable(linea):
        return True

    if tipo == "4.2" and len(re.findall(r"^\s*INITIALIZE\s+[a-zA-Z]\w*\s*$", linea)) == 1:
        return True

    elif tipo == "4.6" and len(re.findall(r"^\s*READ\s+[a-zA-Z]\w*\s*$", linea)) == 1:
        return True

    elif tipo in ["4.3", "4.3.2"] and len(re.findall(r"^\s*GREATER\s+\w+\s+THAN\s+\w+\s*$", linea)) == 1:
        linea = ("".join(linea.split("GREATER"))).split("THAN")
        if isVariable(linea[0]) and isVariable(linea[1]):
            return True
        return False

    elif tipo in ["4.3", "4.3.2"] and len(re.findall(r"^\s*SMALLER\s+\w+\s+THAN\s+\w+\s*$", linea)) == 1:
        linea = ("".join(linea.split("SMALLER"))).split("THAN")
        if isVariable(linea[0]) and isVariable(linea[1]):
            return True
        return False

    elif tipo == "4.2" and len(re.findall(r"^\s*SET\s+\w+\s+TO\s+[^$]*$", linea)) == 1:

        linea = ("".join(linea.split("SET"))).split("TO")
        if len(linea) > 2:
            parteUno = linea[0]
            parteDos = linea[1:]
            parteDos = "TO".join(parteDos)
            linea = [parteUno, parteDos]

        if isVariable(linea[0]) and isValid(linea[1], "4.3"):
            return True
        return False

    elif tipo == "4.6" and len(re.findall(r"^\s*PRINT\s+[^$]*$", linea)) == 1:
        linea = linea.split("PRINT")
        linea = "".join(linea)
        if isValid(linea, "4.3"):
            return True
        return False

    elif tipo in ["4.3", "4.3.1"] and len(re.findall(r"^\s*SUBTRACT\s+[^$]*$", linea)) == 1:

        linea = linea.split("SUBTRACT", 1)
        linea = "".join(linea)
        linea = linea.split("TO")

        if len(linea) == 1:
            return False

        if len(linea) > 2:

            indice = 0
            while indice < len(linea)-1:
                parteUno = linea[0:indice+1]
                parteDos = linea[indice+1:]

                if len(parteUno) > 1:
                    parteUno = "TO".join(parteUno)
                else:
                    parteUno = parteUno[0]

                if len(parteDos) > 1:
                    parteDos = "TO".join(parteDos)
                else:
                    parteDos = parteDos[0]

                lineaNueva = [parteUno, parteDos]

                if isValid(lineaNueva[0], "4.3.1") and isValid(lineaNueva[1], "4.3.1"):
                    return True

                indice +=1
            return False

        if isValid(linea[0], "4.3.1") and isValid(linea[1], "4.3.1"):
            return True
        return False

    elif tipo in ["4.3", "4.3.1"] and len(re.findall(r"^\s*SUM\s+[^$]*$", linea)) == 1:

        linea = linea.split("SUM", 1)
        linea = "".join(linea)
        linea = linea.split("TO")

        if len(linea) == 1:
            return False

        if len(linea) > 2:

            indice = 0
            while indice < len(linea)-1:
                parteUno = linea[0:indice+1]
                parteDos = linea[indice+1:]

                if len(parteUno) > 1:
                    parteUno = "TO".join(parteUno)

                else:
                    parteUno = parteUno[0]

                if len(parteDos) > 1:
                    parteDos = "TO".join(parteDos)

                else:
                    parteDos = parteDos[0]

                lineaNueva = [parteUno, parteDos]
                if isValid(lineaNueva[0], "4.3.1") and isValid(lineaNueva[1], "4.3.1"):
                    return True

                indice +=1
            return False

        if isValid(linea[0], "4.3.1") and isValid(linea[1], "4.3.1"):
            return True
        return False

    elif tipo in ["4.3", "4.3.1"] and len(re.findall(r"^\s*MULTIPLY\s+[^$]*$", linea)) == 1:

        linea = linea.split("MULTIPLY", 1)
        linea = "".join(linea)
        linea = linea.split("BY")

        if len(linea) == 1:
            return False

        if len(linea) > 2:
            indice = 0
            while indice < len(linea)-1:
                parteUno = linea[0:indice+1]
                parteDos = linea[indice+1:]

                if len(parteUno) > 1:
                    parteUno = "BY".join(parteUno)
                else:
                    parteUno = parteUno[0]

                if len(parteDos) > 1:
                    parteDos = "BY".join(parteDos)
                else:
                    parteDos = parteDos[0]

                lineaNueva = [parteUno, parteDos]
                if isValid(lineaNueva[0], "4.3.1") and isValid(lineaNueva[1], "4.3.1"):
                    return True

                indice +=1
            return False

        if isValid(linea[0], "4.3.1") and isValid(linea[1], "4.3.1"):
            return True
        return False

    elif tipo in ["4.3", "4.3.1"] and len(re.findall(r"^\s*DIVIDE\s+[^$]*$", linea)) == 1:

        linea = linea.split("DIVIDE", 1)
        linea = "".join(linea)
        linea = linea.split("BY")

        if len(linea) == 1:
            return False

        if len(linea) > 2:

            indice = 0
            while indice < len(linea)-1:
                parteUno = linea[0:indice+1]
                parteDos = linea[indice+1:]

                if len(parteUno) > 1:
                    parteUno = "BY".join(parteUno)
                else:
                    parteUno = parteUno[0]

                if len(parteDos) > 1:
                    parteDos = "BY".join(parteDos)
                else:
                    parteDos = parteDos[0]

                lineaNueva = [parteUno, parteDos]
                if isValid(lineaNueva[0], "4.3.1") and isValid(lineaNueva[1], "4.3.1"):
                    return True

                indice +=1
            return False

        if isValid(linea[0], "4.3.1") and isValid(linea[1], "4.3.1"):
            return True
        return False


    elif tipo in ["4.3.2", "4.3"] and len(re.findall(r"^\s*NO\s+[^$]*$", linea)) == 1:
        linea = linea.split("NO", 1)
        linea = "".join(linea)
        if isValid(linea, "4.3.2"):
            return True
        return False


    elif tipo in ["4.3.2", "4.3"]:

        copiaLinea = linea
        copiaLinea = linea.split(" ")
        lineList = []

        for palabra in copiaLinea:
            if palabra != "":
                lineList.append(palabra)
        indice = 0
        while indice < len(lineList)-1:

            if lineList[indice] in lista432:

                if lineList[indice+1] == "TO":

                    linea = linea.split(lineList[indice], 1)
                    linea[1] = linea[1].split("TO",1)
                    linea[1] = "".join(linea[1])

                    if isValid(linea[0], "4.3.2") and isValid(linea[1], "4.3.2"):
                        return True
                    return False

                else:

                    linea = linea.split(lineList[indice], 1)
                    if isValid(linea[0], "4.3.2") and isValid(linea[1], "4.3.2"):
                        return True
                    return False

            indice += 1
        return False



### Booleano que indica si existe algun programa bien deficino por su Procedure y End
isProgram = False

### Listas que contienen los indices de todas las ocurrencias de Procedure o End
Procedure = []
End_Procedure = []

programSegments = []

### Aqui se lee el archivo para encontrar cada linea que contenga un procedure o un end, y se agregan a la lista correspondiente.

index = 0
while index < len(textlist):
    if len(re.findall(r"^\s*PROCEDURE\s+[a-zA-Z]\w*\s*$", textlist[index])) == 1:
        if isVariable("".join(textlist[index].split("PROCEDURE"))):
            Procedure.append(index)

    elif len(re.findall(r"^\s*END\s+PROCEDURE\s*$", textlist[index])) == 1:
        End_Procedure.append(index)
    index += 1

if len(Procedure) == 0 or len(End_Procedure) == 0:
    Salida.write("********************\nNo hay Programa\n********************\n")
    Salida.close()
    sys.exit()
### Si no hay programas, el archivo está completamente malo, asi que se cierra con las lineas marcadas como error

elif len(Procedure) == 1 and len(End_Procedure) == 1:
    if Procedure[0] < End_Procedure[0]:
        isProgram = True
        programas.append(list())
        for indice in range(Procedure[0], End_Procedure[0]+1):
            programas[0].append(indice)
    else:
        Salida.write("********************\nNo hay Programa\n********************\n")
        Salida.close()
        sys.exit()

### En cualquiera de los casos, si no existe programa, se termina la ejecución creando el archivo de error.

else:
    ### Aquí toma cada ocurrencia de Procedure o End, y los ordena por indice, y, a la vez, los asigna a una tupla que especifica a qué corresponde
    #indexList = []
    for index in Procedure:
        programSegments.append((index, "S"))
    for index in End_Procedure:
        programSegments.append((index, "E"))
    programSegments.sort()
    ### La lista se ordena según sus indicen en orden creciente

    index = 0
    cantidadProgramas = 0
    while index < (len(programSegments)-1):
        if (programSegments[index][1] == "S") and (programSegments[index+1][1] == "E"):
            programas.append(list())
            for indice in range(programSegments[index][0], programSegments[index+1][0]+1):
                #indexList.append(indice)
                programas[cantidadProgramas].append(indice)
            cantidadProgramas += 1

### Si dentro de la lista existe una secuencia donde un PROCEDURE es seguido por un END, se considera un programa válido


        index += 1
    #if len(indexList) > 0:
    if cantidadProgramas > 0:
        isProgram = True
    else:
        Salida.write("********************\nNo hay Programa\n********************\n")
        Salida.close()
        sys.exit()

archivo = archivo.split("\n")
listaIf = []
listaElse = []
ListaEnd = []


### Ahora lee cada programa de forma independiente, y restringe cada uno a sus limites de indice, de forma que un bloque iniciado dentro de un programa no
### puede continuar dentro de otro distinto

for programa in programas:
    if len(programa) == 0:
        continue
    else:
        for index in programa:
            #print("P1 :",index, textlist[index])
            tipoComando = ""
            for parte in (textlist[index]).split(" "):      # Busca identificar de qué tipo es el primer comando de la linea

                if parte != "" and parte in commandType:    # Si lo encuentra, lo identifica como el tipo correspondiente
                    tipoComando = commandType[parte]
                    break

                elif parte != "":               # Si no lo logra asociar a nada, lo envía como "4.3.2", pues es el unico que puede no empezar con un comando
                    tipoComando = "4.3.2"       # Y, en el peor de los casos, la linea está incorrecta.
                    break

            if len(re.findall(r"^\s*IF\s+[^$]*$", textlist[index])) == 1:
                if isCondicional(textlist[index], index):
                    listaIf.append(index)

            elif len(re.findall(r"^\s*ELSE\s*$", textlist[index])) == 1:
                listaElse.append(index)

            elif len(re.findall(r"^\s*END\s+IF\s*$", textlist[index])) == 1:
                ListaEnd.append(index)

            if len(re.findall(r"^\s*WHILE\s+[^$]*$", textlist[index])) == 1:
                index = indexCiclo(textlist[index], index, False, programa[-1])
                if index >= programa[-1]:
                    break

            elif isValid(textlist[index], tipoComando):
                archivo[index] = traducirSentencia(textlist[index])

            index += 1
### A medida que revisa las lineas, las envia a la funcion que evalúa si estas son validas, y, de serlo, las envia para su traducción.
### Tambien, si recivbe alguna linea que corresponde a un bloque de IF, las agrega a las listas que luego serán revisadas para encontrar cual es su orden correspondiente

checkList(listaIf, listaElse, ListaEnd)

##############################################################################
##############################################################################

indexList = []
for programa in programas:
    for indice in programa:
        indexList.append(indice)

index = 0
while index < len(textlist):
    if (index not in indexList) and (textlist[index] != ""):
        archivo[index] = textlist[index] + " #Error"

    else:
        if len(re.findall(r"^\s*PROCEDURE\s+[a-zA-Z]\w*\s*$", textlist[index])) == 1:
            linea = textlist[index].split("PROCEDURE")
            linea2 = "".join(linea)
            if isVariable(linea2):
                archivo[index] = "PROCEDIMIENTO".join(linea)

        elif len(re.findall(r"^\s*END\s+PROCEDURE\s*$", textlist[index])) == 1:
            archivo[index] = "FIN".join(("PROCEDIMIENTO".join(textlist[index].split("PROCEDURE"))).split("END"))

    index += 1
#print("IndexList = ", indexList)

### Traduce las lineas que contienen los Procedure y End



### Esta es mi zona de debug, wena choro como andamo'h
"""
archivo3 = archivo
i = 0
while i < len(archivo3):
    archivo3[i] = str(i)+"  "+archivo3[i]
    i += 1
archivo3 = "\n".join(archivo3)
print(archivo3)
#print("\n\n")
#print("Lista IF", listaIf)
#print("Lista El", listaElse)
#print("Lista En", ListaEnd)
"""

archivo2 = archivo2.split("\n")

#print(programas)
#print(cantidadProgramas)

index = 0
while index < len(textlist):
    if textlist[index] == "":
        archivo[index] = ""
        archivo2[index] = ""
    index += 1
archivo = "\n".join(archivo)
archivo2 = "\n".join(archivo2)
# En esto ultimo se quitan los #Error de las lineas que solo contienen "\n"


### Creo que este caso está de más, de ocurrir debería haber sido identificado antes. Pero, por si acaso...
if isProgram == False:
    Salida.write("***************\nNo hay programa\n***************\n")
 #   print(archivo2)

if isProgram == True:
    Salida.write(archivo)
#    print(archivo)

Salida.close()

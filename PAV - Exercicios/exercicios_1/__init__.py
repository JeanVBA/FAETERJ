"Import dos menus dos exercicios"
import sys
sys.path.append('')
from exercicios_1.ano_bissexto.menu_ano_bissexto import selecao_de_caso
from exercicios_1.Bhaskara.MenuBhaskara import implementacao_bhaskara
from exercicios_1.CalculoArea.MenuArea import selecao_area
from exercicios_1.MediaSalarial.MenuMedia import selecao_registro

while True:
    ESCOLHA = int(input("1 - Bhaskara\n"+
                        "2 - Ano Bissexto\n"+
                        "3 - Area\n"+
                        "4 - Media Salarial\n"+
                        "5 - Sair"
                        "Escolha a operação desejada:"))
    if ESCOLHA == 1:
        implementacao_bhaskara()
    if ESCOLHA == 2:
        selecao_de_caso()
    if ESCOLHA == 3:
        selecao_area()
    if ESCOLHA == 4:
        selecao_registro()
    if ESCOLHA == 5:
        break

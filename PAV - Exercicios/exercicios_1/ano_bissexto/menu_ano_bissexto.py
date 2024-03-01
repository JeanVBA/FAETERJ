"Importa as fomulas"
from exercicios_1.ano_bissexto.validacao_bissexto import Formulas

def selecao_de_caso():
    "Importa as fomulas"
    escolha_de_alternativa = int(input("1 - Verificação de ano\n"+
                        "2 - Soma total de anos bissexto em range\n"+
                        "Escolha a operação desejada:"))
    if escolha_de_alternativa == 1:
        valida = Formulas.escolha_ano_bissexto(0, int(input("Digite o ano:")))
        if valida:
            print("É bissexto")
        else:
            print("Não é bissexto")
    if escolha_de_alternativa == 2:
        ano_inicio = int(input("Digite o ano de inicio:"))
        ano_final = int(input("Digite o ultimo ano desejado:"))
        qtd_anos = Formulas.quantidade_anos_bissexto_range(0, ano_inicio, ano_final)
        print(f"Total de anos bissextos encontrados:{qtd_anos}")

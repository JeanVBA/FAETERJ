class Formulas:
    "Classe com as validações"
    def escolha_ano_bissexto(self, ano):
        "Verifica se o ano é bissexto"
        return (ano % 4 == 0 and (ano % 100 != 0 or ano % 400 == 0))
    def quantidade_anos_bissexto_range(self, ano_inicio:int, ano_final:int):
        "Conta quanto anos bissexto tem num determinado periodo"
        somatoria = ano_final - ano_inicio
        value = 0
        for i in range(somatoria):
            ano = ano_inicio + i
            if(ano % 4 == 0 and (ano % 100 != 0 or ano % 400 == 0)):
                value += 1
        return value

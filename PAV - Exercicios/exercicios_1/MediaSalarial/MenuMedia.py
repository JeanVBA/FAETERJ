import sys
sys.path.append('')
from Pessoa import registro_pessoa


def selecao_registro():
    "Escolha"
    registros = []
    escolha_de_alternativa = int(input("1 - Cadastro manual\n"+
                                       "2 - Cadastro automatico\n"+
                                       "Escolha a operação desejada:"))
    if escolha_de_alternativa == 1:
        for i in range(15):
            idade = int(input("Digite a idade:"))
            while True:
                sexo = str(input("Digite F para feminino M para masculino:").upper())
                if sexo in ['F', 'M']:
                    break
                else:
                    print("Sexo invalido, insira novamente")
            salario = float(input("Digite o salario:"))
            n_filhos = int(input("Digite o numero de filhos:"))
            registros.append(registro_pessoa(idade,sexo,salario,n_filhos))
    if escolha_de_alternativa == 2:
        registros = [ registro_pessoa(idade=25, sexo='M', salario=3000.0, n_filhos=1),
        registro_pessoa(idade=30, sexo='F', salario=2500.0, n_filhos=2),
        registro_pessoa(idade=40, sexo='M', salario=4000.0, n_filhos=3),
        registro_pessoa(idade=35, sexo='F', salario=3500.0, n_filhos=2),
        registro_pessoa(idade=28, sexo='M', salario=2800.0, n_filhos=1),
        registro_pessoa(idade=32, sexo='F', salario=500.0, n_filhos=3),
        registro_pessoa(idade=45, sexo='M', salario=5000.0, n_filhos=3),
        registro_pessoa(idade=29, sexo='F', salario=2700.0, n_filhos=1),
        registro_pessoa(idade=33, sexo='M', salario=3300.0, n_filhos=2),
        registro_pessoa(idade=38, sexo='F', salario=3800.0, n_filhos=3),
        registro_pessoa(idade=42, sexo='M', salario=4200.0, n_filhos=2),
        registro_pessoa(idade=31, sexo='F', salario=3100.0, n_filhos=1),
        registro_pessoa(idade=37, sexo='M', salario=3700.0, n_filhos=2),
        registro_pessoa(idade=34, sexo='F', salario=3400.0, n_filhos=3),
        registro_pessoa(idade=26, sexo='M', salario=2600.0, n_filhos=1),
        ]
    pessoa = registro_pessoa(0,'',0,0)
    formatado = f"{pessoa.salario_medio(registros):.{3}f}"
    print(f"Salario médio:{formatado}")
    print(f"Menor idade:{pessoa.menor_idade(registros)}")
    print(f"Maior idade:{pessoa.maior_idade(registros)}")
    print(f"Numero de mulheres:{len(pessoa.mulheres_tres_filhos_ate_500(registros))}")

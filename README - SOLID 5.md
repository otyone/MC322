PRINCÍPIOS DE PADRÃO SOLID 5 - DIP (Dependency Inversion Principle)
"Quaisquer classes superiores devem sempre depender da abstração da classe e não do detalhe"
Razão: reduzir o acoplamento entre classes, utilizando uma abstração "entre camadas", isto é, entre classes relacionadas
Utilização: foi criada a classe de nível alto "Principal", que determina um dispositivo que seria o principal a ser utilizado. Logo, foi testado que a classe de nível alto lida com a classe abstrata "Dispositivo" e não com suas subclasses específicas "Tela" e "Noticiador"
PRINCÍPIOS SOLID - TOTAL

PRINCÍPIOS DE PADRÃO SOLID 1 - SRP (Single Responsibility Principle)
"O princípio de responsabilidade única é um princípio de programação de computador que afirma que cada módulo ou classe deve ter responsabilidade sobre uma única parte da funcionalidade fornecida pelo software"
Razão: simplificar e "enxugar" classes e módulos no projeto, atribuindo apenas as responsabilidades apropriadas para cada função específica
Utilização: foram criadas a interface "Mostrar" e a classe "Console" que apresentam informações específicas sobre algum item,membro, etc sem criar tal função na classe, logo, essa responsabilidade é propriamente dita apenas para a interface/classe

PRINCÍPIOS DE PADRÃO SOLID 2 - OCP (Open Closed Principle)
"As entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, mas fechadas para modificação."
Razão: quaisquer mudanças ou erros/bugs encontrados em novas funções implementadas não afetam o resto do programam e não necessita ampla e total teste e revisão do programa
Utilização: foram criadas a nova classe "Relatório" que utiliza a mesma interface "Mostrar" porém não altera nem a interface nem a última classe criada ("Console"), apenas atribuindo novos métodos. Assim, a funcionalidade anterior não é comprometida

PRINCÍPIOS DE PADRÃO SOLID 3 - LSP (Liskov Substitution Principle)
"se S é um subtipo de T, então objetos do tipo T em um programa podem ser substituídos por objetos do tipo S sem alterar nenhuma das propriedades desejáveis desse programa"
Razão: qualquer utilização de subclasses deverá respeitar (e não utilizar total override) a superclasse, e portanto, deverá funcionar apropriadamente até que uma classe não subtipo tente ser utilizada
Utilização: foram criadas as novas subclasses "Tela" e "Noticiador" (da superclasse "Dispositivo") e testado o funcionamento de ambas, comprovando que o programa continua sua funcionabilidade mesmo com outros subtipos

PRINCÍPIOS DE PADRÃO SOLID 4 - ISP (Interface Segregation Principle)
"Seguir esse princípio ajuda o sistema a se manter flexível ao fazer alterações na lógica de trabalho e adequado para refatoração"
Razão: manter o sistema organizado e fácil de alterar, consertar e reprogramar ao manter interfaces concisas, pequenas e específicas
Utilização: foi criado o novo método "Notícia" e implementando na classe "Noticiador", logo, a classe possui um método específico para sua atividade (enquanto, por exemplo, "Relatório" também utiliza seu método específico, sem compartilhar)

PRINCÍPIOS DE PADRÃO SOLID 5 - DIP (Dependency Inversion Principle)
"Quaisquer classes superiores devem sempre depender da abstração da classe e não do detalhe"
Razão: reduzir o acoplamento entre classes, utilizando uma abstração "entre camadas", isto é, entre classes relacionadas
Utilização: foi criada a classe de nível alto "Principal", que determina um dispositivo que seria o principal a ser utilizado. Logo, foi testado que a classe de nível alto lida com a classe abstrata "Dispositivo" e não com suas subclasses específicas "Tela" e "Noticiador"
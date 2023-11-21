PRINCÍPIOS DE PADRÃO SOLID 2 - OCP (Open Closed Principle)
"As entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, mas fechadas para modificação."
Razão: quaisquer mudanças ou erros/bugs encontrados em novas funções implementadas não afetam o resto do programam e não necessita ampla e total teste e revisão do programa
Utilização: foram criadas a nova classe "Relatório" que utiliza a mesma interface "Mostrar" porém não altera nem a interface nem a última classe criada ("Console"), apenas atribuindo novos métodos. Assim, a funcionalidade anterior não é comprometida

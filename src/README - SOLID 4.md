PRINCÍPIOS DE PADRÃO SOLID 4 - ISP (Interface Segregation Principle)
"Seguir esse princípio ajuda o sistema a se manter flexível ao fazer alterações na lógica de trabalho e adequado para refatoração"
Razão: manter o sistema organizado e fácil de alterar, consertar e reprogramar ao manter interfaces concisas, pequenas e específicas
Utilização: foi criado o novo método "Notícia" e implementando na classe "Noticiador", logo, a classe possui um método específico para sua atividade (enquanto, por exemplo, "Relatório" também utiliza seu método específico, sem compartilhar)
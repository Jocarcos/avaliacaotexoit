INSERT INTO tb_vencedor(YEAR,TITLE,STUDIOS,PRODUCERS,WINNER) 
SELECT YEAR,TITLE,STUDIOS,PRODUCERS,WINNER
FROM CSVREAD('../VencedoresPiorFilme/src/main/resources/movielist.csv', NULL, 'fieldSeparator=;', 'charset=UTF-8');
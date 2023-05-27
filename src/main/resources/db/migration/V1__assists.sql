CREATE TABLE `assistances` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `description` varchar(255) NOT NULL,
                               `name` varchar(150) NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO assistances (name, description) VALUES ('Troca de aparelho', 'Troca de aparelho decodificador de sinal');
INSERT INTO assistances (name, description) VALUES ('Troca de cabo interno', 'Troca de cabo interno');
INSERT INTO assistances (name, description) VALUES ('Troca de fiação interna', 'Substituição de fiação interna da residência');
INSERT INTO assistances (name, description) VALUES ('Manutenção em fogão', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Manutenção em geladeira', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Manutenção em máquina de lavar', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Manutenção em ar condicionado', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Instalação de chuveiro elétrico', 'Instalação de chuveiro elétrico');
INSERT INTO assistances (name, description) VALUES ('Troca de lâmpadas', 'Substituição de lâmpadas queimadas');
INSERT INTO assistances (name, description) VALUES ('Desentupimento de pia', 'Desentupimento de pia de cozinha ou banheiro');
INSERT INTO assistances (name, description) VALUES ('Instalação de fechadura eletrônica', 'Instalação de fechadura eletrônica');
INSERT INTO assistances (name, description) VALUES ('Limpeza de caixa de água', 'Limpeza e higienização de caixa de água');
INSERT INTO assistances (name, description) VALUES ('Reparo em torneira vazando', 'Reparo em torneira que está com vazamento');
INSERT INTO assistances (name, description) VALUES ('Instalação de ventilador de teto', 'Instalação de ventilador de teto');
INSERT INTO assistances (name, description) VALUES ('Manutenção em aquecedor a gás', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Desentupimento de vaso sanitário', 'Desentupimento de vaso sanitário');
INSERT INTO assistances (name, description) VALUES ('Instalação de antena de TV', 'Instalação de antena de TV');
INSERT INTO assistances (name, description) VALUES ('Troca de resistência de chuveiro', 'Substituição de resistência de chuveiro');
INSERT INTO assistances (name, description) VALUES ('Reparo em torneira pingando', 'Reparo em torneira que está pingando');
INSERT INTO assistances (name, description) VALUES ('Limpeza de ar condicionado', 'Limpeza e higienização de ar condicionado');
INSERT INTO assistances (name, description) VALUES ('Manutenção em secadora de roupas', 'Reparo sem necessidade de compra de peças');
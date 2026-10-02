-- ============================================================
-- EXERCÍCIO 2 — Modelagem do Banco de Dados (PostgreSQL)
-- ============================================================

-- 1. Criação da Tabela 'item'
CREATE TABLE item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    titulo VARCHAR(255) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('LIVRO', 'REVISTA','DVD')),
    autor VARCHAR(255),
    edicao INT,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

-- 2. Criação da Tabela 'usuario'
CREATE TABLE usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('ALUNO', 'PROFESSOR')),
    limite_itens INT NOT NULL DEFAULT 3
);

-- 3. Criação da Tabela 'emprestimo'
CREATE TABLE emprestimo (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id BIGINT NOT NULL REFERENCES item(id),
    usuario_id BIGINT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL DEFAULT CURRENT_DATE,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE, -- Sem NOT NULL, pois fica NULL enquanto não for devolvido
    valor_multa NUMERIC(10, 2) DEFAULT 0.00
);

-- ============================================================
-- Carga de Dados de Teste
-- ============================================================

-- Inserindo 4 itens (2 livros e 2 revistas)
INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('LIV-001', 'Java para Iniciantes', 'LIVRO', 'Herbert Schildt', 8, FALSE), -- Emprestado
('LIV-002', 'Estruturas de Dados e Algoritmos', 'LIVRO', 'Robert Lafore', 2, TRUE),
('REV-001', 'Mundo Estranho - Edição 200', 'REVISTA', 'Editora Abril', 200, TRUE),
('REV-002', 'Revista Java Magazine', 'REVISTA', 'DevMedia', 15, TRUE),
('DVD-001', 'Piratas do Vale do Silicio - 1999', 'DVD', 'Tnt', 1, FALSE), -- Emprestado
('DVD-002', 'O jogo da Imitação - 2014', 'DVD', 'Black Bear Pictures', 1, TRUE);

-- Inserindo 2 usuários (1 aluno e 1 professor)
INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Carolina Silva', 'ALUNO', 3),
('Dumbo', 'PROFESSOR', 5);

-- Inserindo 2 empréstimos:
-- 1º Empréstimo: Concluído/Devolvido
INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(2, 2, '2026-09-01', '2026-09-15', '2026-09-10', 0.00);

-- 2º Empréstimo: Em aberto (data_devolucao permanece NULL)
INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(1, 1, '2026-09-25', '2026-10-09', NULL, 0.00),
(5, 1, '2026-09-30', '2026-10-13', NULL, 0.00);


-- ============================================================
-- EXERCÍCIO 3 — Consulta no Banco de Dados (PostgreSQL)
-- ============================================================

-- 1. Listar todo o acervo, com código, título, tipo e disponibilidade
SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item;

-- 2. Listar os empréstimos em aberto, com o nome do usuário e o título do item
SELECT
    u.nome AS usuario,
    i.titulo AS item
FROM emprestimo e
JOIN usuario u ON e.usuario_id = u.id
JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL;

-- 3. Calcular o total de multas acumuladas por usuário
SELECT
    u.nome AS usuario,
    SUM(e.valor_multa) AS total_multas
FROM usuario u
JOIN emprestimo e ON u.id = e.usuario_id
GROUP BY u.id, u.nome;

-- 4. Listar os itens que nunca foram emprestados
SELECT
    i.codigo,
    i.titulo,
    i.tipo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL;
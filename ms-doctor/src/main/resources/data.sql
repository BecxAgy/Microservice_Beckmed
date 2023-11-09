-- Adicionar endereços
INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 1', '123', 'Apto 101', 'Bairro 1', 'Cidade 1', 'UF1', 'CEP1');

INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 2', '456', 'Apto 202', 'Bairro 2', 'Cidade 2', 'UF2', 'CEP2');

INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 3', '789', 'Apto 303', 'Bairro 3', 'Cidade 3', 'UF3', 'CEP3');

INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 4', '101', 'Apto 404', 'Bairro 4', 'Cidade 4', 'UF4', 'CEP4');
INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 1', '123', 'Apto 101', 'Bairro 1', 'Cidade 1', 'UF1', 'CEP1');

INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 2', '456', 'Apto 202', 'Bairro 2', 'Cidade 2', 'UF2', 'CEP2');

INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 3', '789', 'Apto 303', 'Bairro 3', 'Cidade 3', 'UF3', 'CEP3');

INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 4', '101', 'Apto 404', 'Bairro 4', 'Cidade 4', 'UF4', 'CEP4');

INSERT INTO addresses (street, number, complement, neighborhood, city, state, postal_code) VALUES
('Rua 4', '101', 'Apto 404', 'Bairro 4', 'Cidade 4', 'UF4', 'CEP4');

-- Adicionar médicos com endereços
INSERT INTO doctors (active, name, email, phone, crm, speciality, address_id) VALUES
(true, 'Médico 1', 'medico1@example.com', '(11) 1111-1111', 'CRM001', 'Orthopedics', 1);

INSERT INTO doctors (active, name, email, phone, crm, speciality, address_id) VALUES
(true, 'Médico 2', 'medico2@example.com', '(22) 2222-2222', 'CRM002', 'Cardiology', 2);

INSERT INTO doctors (active, name, email, phone, crm, speciality, address_id) VALUES
(true, 'Médico 3', 'medico3@example.com', '(33) 3333-3333', 'CRM003', 'Gynaecology', 3);

INSERT INTO doctors (active, name, email, phone, crm, speciality, address_id) VALUES
(true, 'Médico 4', 'medico4@example.com', '(44) 4444-4444', 'CRM004', 'Dermatology', 4);
```sql
create database congty;
use congty;

-- Tạo bảng company
CREATE TABLE company (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Tạo bảng department
CREATE TABLE department (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    company_id BINARY(16) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);

-- Tạo bảng employee
CREATE TABLE employee (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE
);

-- Bảng trung gian: department - employee
CREATE TABLE department_employee (
    department_id BINARY(16) NOT NULL,
    employee_id BINARY(16) NOT NULL,
    PRIMARY KEY (department_id, employee_id),
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

-- Bảng team_group
CREATE TABLE team_group (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    department_id BINARY(16) NOT NULL,
    leader_id BINARY(16) NOT NULL,
    translator_id BINARY(16) NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (leader_id) REFERENCES employee(id),
    FOREIGN KEY (translator_id) REFERENCES employee(id),
    CONSTRAINT chk_leader_translator_different CHECK (leader_id != translator_id)
);

-- Bảng trung gian: group - member
CREATE TABLE group_member (
    group_id BINARY(16) NOT NULL,
    employee_id BINARY(16) NOT NULL,
    PRIMARY KEY (group_id, employee_id),
    FOREIGN KEY (group_id) REFERENCES team_group(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);


SELECT * FROM congty.company;



-- ======================================================
-- Companies (3)
-- ======================================================
INSERT INTO company (id, name) VALUES
(UUID_TO_BIN('11111111-1111-4111-8111-111111111111'), 'TechGlobal Inc.'),
(UUID_TO_BIN('22222222-2222-4222-9222-222222222222'), 'InnovateX Co.'),
(UUID_TO_BIN('33333333-3333-4333-a333-333333333333'), 'FutureSoft Ltd.');

-- ======================================================
-- Employees (9) — tất cả UUID hợp lệ version 4
-- ======================================================
INSERT INTO employee (id, name, email) VALUES
(UUID_TO_BIN('a1a1a1a1-a1a1-41a1-81a1-a1a1a1a1a1a1'), 'Alice Nguyen', 'alice@techglobal.com'),
(UUID_TO_BIN('b2b2b2b2-b2b2-42b2-92b2-b2b2b2b2b2b2'), 'Bob Tran', 'bob@techglobal.com'),
(UUID_TO_BIN('c3c3c3c3-c3c3-43c3-93c3-c3c3c3c3c3c3'), 'Charlie Le', 'charlie@techglobal.com'),
(UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4'), 'Diana Pham', 'diana@innovatex.com'),
(UUID_TO_BIN('e5e5e5e5-e5e5-45e5-b5e5-e5e5e5e5e5e5'), 'Eva Ho', 'eva@innovatex.com'),
(UUID_TO_BIN('f6f6f6f6-f6f6-46f6-86f6-f6f6f6f6f6f6'), 'Felix Mai', 'felix@futuresoft.com'),
(UUID_TO_BIN('a7a7a7a7-a7a7-47a7-97a7-a7a7a7a7a7a7'), 'Grace Vu', 'grace@futuresoft.com'),
(UUID_TO_BIN('b8b8b8b8-b8b8-48b8-98b8-b8b8b8b8b8b8'), 'Henry Dao', 'henry@futuresoft.com'),
(UUID_TO_BIN('c9c9c9c9-c9c9-49c9-99c9-c9c9c9c9c9c9'), 'Iris Do', 'iris@techglobal.com');

-- ======================================================
-- Departments (6)
-- ======================================================
INSERT INTO department (id, name, company_id) VALUES
(UUID_TO_BIN('d1d1d1d1-d1d1-41d1-81d1-d1d1d1d1d1d1'), 'Engineering',          UUID_TO_BIN('11111111-1111-4111-8111-111111111111')),
(UUID_TO_BIN('d2d2d2d2-d2d2-42d2-92d2-d2d2d2d2d2d2'), 'Human Resources',     UUID_TO_BIN('11111111-1111-4111-8111-111111111111')),
(UUID_TO_BIN('d3d3d3d3-d3d3-43d3-93d3-d3d3d3d3d3d3'), 'R&D',                UUID_TO_BIN('22222222-2222-4222-9222-222222222222')),
(UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4'), 'Product',             UUID_TO_BIN('22222222-2222-4222-9222-222222222222')),
(UUID_TO_BIN('d5d5d5d5-d5d5-45d5-b5d5-d5d5d5d5d5d5'), 'QA Team',             UUID_TO_BIN('33333333-3333-4333-a333-333333333333')),
(UUID_TO_BIN('d6d6d6d6-d6d6-46d6-86d6-d6d6d6d6d6d6'), 'DevOps',              UUID_TO_BIN('33333333-3333-4333-a333-333333333333'));

-- ======================================================
-- Department-Employee assignments
-- ======================================================
-- Engineering: Alice, Bob, Iris
INSERT INTO department_employee (department_id, employee_id) VALUES
(UUID_TO_BIN('d1d1d1d1-d1d1-41d1-81d1-d1d1d1d1d1d1'), UUID_TO_BIN('a1a1a1a1-a1a1-41a1-81a1-a1a1a1a1a1a1')),
(UUID_TO_BIN('d1d1d1d1-d1d1-41d1-81d1-d1d1d1d1d1d1'), UUID_TO_BIN('b2b2b2b2-b2b2-42b2-92b2-b2b2b2b2b2b2')),
(UUID_TO_BIN('d1d1d1d1-d1d1-41d1-81d1-d1d1d1d1d1d1'), UUID_TO_BIN('c9c9c9c9-c9c9-49c9-99c9-c9c9c9c9c9c9'));

-- HR: Charlie, Diana, Eva
INSERT INTO department_employee (department_id, employee_id) VALUES
(UUID_TO_BIN('d2d2d2d2-d2d2-42d2-92d2-d2d2d2d2d2d2'), UUID_TO_BIN('c3c3c3c3-c3c3-43c3-93c3-c3c3c3c3c3c3')),
(UUID_TO_BIN('d2d2d2d2-d2d2-42d2-92d2-d2d2d2d2d2d2'), UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4')),
(UUID_TO_BIN('d2d2d2d2-d2d2-42d2-92d2-d2d2d2d2d2d2'), UUID_TO_BIN('e5e5e5e5-e5e5-45e5-b5e5-e5e5e5e5e5e5'));

-- R&D: Felix, Grace, Henry
INSERT INTO department_employee (department_id, employee_id) VALUES
(UUID_TO_BIN('d3d3d3d3-d3d3-43d3-93d3-d3d3d3d3d3d3'), UUID_TO_BIN('f6f6f6f6-f6f6-46f6-86f6-f6f6f6f6f6f6')),
(UUID_TO_BIN('d3d3d3d3-d3d3-43d3-93d3-d3d3d3d3d3d3'), UUID_TO_BIN('a7a7a7a7-a7a7-47a7-97a7-a7a7a7a7a7a7')),
(UUID_TO_BIN('d3d3d3d3-d3d3-43d3-93d3-d3d3d3d3d3d3'), UUID_TO_BIN('b8b8b8b8-b8b8-48b8-98b8-b8b8b8b8b8b8'));

-- Product: Alice, Bob, Charlie
INSERT INTO department_employee (department_id, employee_id) VALUES
(UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4'), UUID_TO_BIN('a1a1a1a1-a1a1-41a1-81a1-a1a1a1a1a1a1')),
(UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4'), UUID_TO_BIN('b2b2b2b2-b2b2-42b2-92b2-b2b2b2b2b2b2')),
(UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4'), UUID_TO_BIN('c3c3c3c3-c3c3-43c3-93c3-c3c3c3c3c3c3'));

-- QA Team: Diana, Eva, Felix
INSERT INTO department_employee (department_id, employee_id) VALUES
(UUID_TO_BIN('d5d5d5d5-d5d5-45d5-b5d5-d5d5d5d5d5d5'), UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4')),
(UUID_TO_BIN('d5d5d5d5-d5d5-45d5-b5d5-d5d5d5d5d5d5'), UUID_TO_BIN('e5e5e5e5-e5e5-45e5-b5e5-e5e5e5e5e5e5')),
(UUID_TO_BIN('d5d5d5d5-d5d5-45d5-b5d5-d5d5d5d5d5d5'), UUID_TO_BIN('f6f6f6f6-f6f6-46f6-86f6-f6f6f6f6f6f6'));

-- DevOps: Grace, Henry, Iris
INSERT INTO department_employee (department_id, employee_id) VALUES
(UUID_TO_BIN('d6d6d6d6-d6d6-46d6-86d6-d6d6d6d6d6d6'), UUID_TO_BIN('a7a7a7a7-a7a7-47a7-97a7-a7a7a7a7a7a7')),
(UUID_TO_BIN('d6d6d6d6-d6d6-46d6-86d6-d6d6d6d6d6d6'), UUID_TO_BIN('b8b8b8b8-b8b8-48b8-98b8-b8b8b8b8b8b8')),
(UUID_TO_BIN('d6d6d6d6-d6d6-46d6-86d6-d6d6d6d6d6d6'), UUID_TO_BIN('c9c9c9c9-c9c9-49c9-99c9-c9c9c9c9c9c9'));

-- ======================================================
-- Groups (3)
-- ======================================================
-- Mobile App Team (Engineering)
INSERT INTO team_group (id, name, department_id, leader_id, translator_id) VALUES
(UUID_TO_BIN('f1f1f1f1-f1f1-41f1-81f1-f1f1f1f1f1f1'), 'Mobile App Team',
 UUID_TO_BIN('d1d1d1d1-d1d1-41d1-81d1-d1d1d1d1d1d1'),
 UUID_TO_BIN('a1a1a1a1-a1a1-41a1-81a1-a1a1a1a1a1a1'),
 UUID_TO_BIN('b2b2b2b2-b2b2-42b2-92b2-b2b2b2b2b2b2'));

-- Hiring Taskforce (HR)
INSERT INTO team_group (id, name, department_id, leader_id, translator_id) VALUES
(UUID_TO_BIN('f2f2f2f2-f2f2-42f2-92f2-f2f2f2f2f2f2'), 'Hiring Taskforce',
 UUID_TO_BIN('d2d2d2d2-d2d2-42d2-92d2-d2d2d2d2d2d2'),
 UUID_TO_BIN('c3c3c3c3-c3c3-43c3-93c3-c3c3c3c3c3c3'),
 UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4'));

-- AI Research Group (R&D)
INSERT INTO team_group (id, name, department_id, leader_id, translator_id) VALUES
(UUID_TO_BIN('f3f3f3f3-f3f3-43f3-93f3-f3f3f3f3f3f3'), 'AI Research Group',
 UUID_TO_BIN('d3d3d3d3-d3d3-43d3-93d3-d3d3d3d3d3d3'),
 UUID_TO_BIN('f6f6f6f6-f6f6-46f6-86f6-f6f6f6f6f6f6'),
 UUID_TO_BIN('a7a7a7a7-a7a7-47a7-97a7-a7a7a7a7a7a7'));

-- ======================================================
-- Group Members (bao gồm leader + translator + 1 người khác)
-- ======================================================
-- Group 1: Alice, Bob, Iris
INSERT INTO group_member (group_id, employee_id) VALUES
(UUID_TO_BIN('f1f1f1f1-f1f1-41f1-81f1-f1f1f1f1f1f1'), UUID_TO_BIN('a1a1a1a1-a1a1-41a1-81a1-a1a1a1a1a1a1')),
(UUID_TO_BIN('f1f1f1f1-f1f1-41f1-81f1-f1f1f1f1f1f1'), UUID_TO_BIN('b2b2b2b2-b2b2-42b2-92b2-b2b2b2b2b2b2')),
(UUID_TO_BIN('f1f1f1f1-f1f1-41f1-81f1-f1f1f1f1f1f1'), UUID_TO_BIN('c9c9c9c9-c9c9-49c9-99c9-c9c9c9c9c9c9'));

-- Group 2: Charlie, Diana, Eva
INSERT INTO group_member (group_id, employee_id) VALUES
(UUID_TO_BIN('f2f2f2f2-f2f2-42f2-92f2-f2f2f2f2f2f2'), UUID_TO_BIN('c3c3c3c3-c3c3-43c3-93c3-c3c3c3c3c3c3')),
(UUID_TO_BIN('f2f2f2f2-f2f2-42f2-92f2-f2f2f2f2f2f2'), UUID_TO_BIN('d4d4d4d4-d4d4-44d4-a4d4-d4d4d4d4d4d4')),
(UUID_TO_BIN('f2f2f2f2-f2f2-42f2-92f2-f2f2f2f2f2f2'), UUID_TO_BIN('e5e5e5e5-e5e5-45e5-b5e5-e5e5e5e5e5e5'));

-- Group 3: Felix, Grace, Henry
INSERT INTO group_member (group_id, employee_id) VALUES
(UUID_TO_BIN('f3f3f3f3-f3f3-43f3-93f3-f3f3f3f3f3f3'), UUID_TO_BIN('f6f6f6f6-f6f6-46f6-86f6-f6f6f6f6f6f6')),
(UUID_TO_BIN('f3f3f3f3-f3f3-43f3-93f3-f3f3f3f3f3f3'), UUID_TO_BIN('a7a7a7a7-a7a7-47a7-97a7-a7a7a7a7a7a7')),
(UUID_TO_BIN('f3f3f3f3-f3f3-43f3-93f3-f3f3f3f3f3f3'), UUID_TO_BIN('b8b8b8b8-b8b8-48b8-98b8-b8b8b8b8b8b8'));
```

<img width="414" height="360" alt="image" src="https://github.com/user-attachments/assets/490bfdf2-5ad7-4e09-b745-24b41fb9f65f" />

<img width="507" height="444" alt="image" src="https://github.com/user-attachments/assets/811cfa8c-d471-4673-8d65-b9b8acf677ab" />

<img width="423" height="382" alt="image" src="https://github.com/user-attachments/assets/55bd4a1b-5150-483d-b607-72fb367ff558" />

<img width="454" height="443" alt="image" src="https://github.com/user-attachments/assets/4b8b5574-ce6a-4ccb-82d7-679626ae9300" />


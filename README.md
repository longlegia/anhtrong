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

```

<img width="873" height="882" alt="image" src="https://github.com/user-attachments/assets/709b204c-f3d6-477e-bbf1-8a2dd9fa19d6" />


<img width="703" height="445" alt="image" src="https://github.com/user-attachments/assets/e2a8096c-7512-413f-8af0-70e48122390a" />

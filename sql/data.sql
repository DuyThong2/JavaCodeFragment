-- Create Role Table
CREATE TABLE role (
    id BIGINT PRIMARY KEY IDENTITY(1,1), -- Auto-increment for IDs
    role_name VARCHAR(255) NOT NULL,
    role_description VARCHAR(255),
    available_status VARCHAR(50) NOT NULL CHECK (available_status IN ('ACTIVE', 'INACTIVE', 'DELETED'))
);

-- Create Users Table
CREATE TABLE users (
    id BIGINT PRIMARY KEY IDENTITY(1,1), -- Auto-increment for IDs
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT,
    full_name VARCHAR(255),
    birth_date DATE,
    avatar VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(255),
    gender VARCHAR(10) CHECK (gender IN ('MALE', 'FEMALE')),
    date_updated DATETIME DEFAULT GETDATE(),
    date_created DATETIME DEFAULT GETDATE(),
    available_status VARCHAR(50) CHECK (available_status IN ('ACTIVE', 'INACTIVE', 'DELETED')),
    otp_code VARCHAR(255),
    FOREIGN KEY (role_id) REFERENCES role(id)
);

-- Insert Data into Role Table
INSERT INTO role (role_name, role_description, available_status)
VALUES
    ('ADMIN', 'Administrator role with full access', 'ACTIVE'),
    ('MENTOR', 'Mentor role with limited access', 'ACTIVE'),
    ('STUDENT', 'Student role with restricted access', 'ACTIVE');

-- Insert Data into Users Table
INSERT INTO users (
    username, password, role_id, full_name, birth_date, avatar, email, address, phone, gender, date_updated, date_created, available_status, otp_code
) VALUES
    ('admin_user', 'admin123', 1, 'Admin User', '1985-05-15', NULL, 'admin@example.com', '123 Admin Street', '1234567890', 'MALE', GETDATE(), GETDATE(), 'ACTIVE', NULL),
    ('mentor_user', 'mentor123', 2, 'Mentor User', '1990-07-10', NULL, 'mentor@example.com', '456 Mentor Avenue', '0987654321', 'FEMALE', GETDATE(), GETDATE(), 'ACTIVE', NULL),
    ('student_user', 'student123', 3, 'Student User', '2000-01-20', NULL, 'student@example.com', '789 Student Blvd', '1122334455', 'MALE', GETDATE(), GETDATE(), 'ACTIVE', '1234');

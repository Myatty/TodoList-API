INSERT INTO users (username, email, password) VALUES
('Myint Myat', 'myintmyat@gmail.com', 'xeDIkdn223AS#$'),
('Thurain', 'thurain@gmail.com', 'aBdwG33@kd5');

INSERT INTO tasks (user_id, title, description, status, priority, deadline) VALUES
(1, 'Learn MyBatis', 'Finish MyBatis tutorial', 'PENDING', 2, '2025-12-11 10:00:00'),
(1, 'Write Todo API', 'Implement CRUD endpoints', 'PENDING', 1, '2025-12-12 12:00:00'),
(1, 'Test DB connection', 'Check schema and relationships', 'PENDING', 3, '2025-12-10 16:00:00');

INSERT INTO tasks (user_id, title, description, status, priority, deadline) VALUES
(2, 'Setup Spring Boot project', 'Initialize project structure', 'COMPLETED', 2, '2025-12-09 14:00:00'),
(2, 'Write Unit Tests', 'Test all service layers', 'PENDING', 1, '2025-12-13 09:00:00');

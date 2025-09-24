INSERT INTO patient (birth_date, email, gender, name, blood_group)
VALUES
('1990-05-14', 'john.doe@example.com', 'Male', 'John Doe', 'A_POSITIVE'),
('1985-11-23', 'jane.smith@example.com', 'Female', 'Jane Smith', 'B_NEGATIVE'),
('1992-07-09', 'michael.lee@example.com', 'Male', 'Michael Lee', 'O_POSITIVE'),
('1998-03-30', 'sophia.khan@example.com', 'Female', 'Sophia Khan', 'AB_POSITIVE'),
('2001-12-17', 'alex.johnson@example.com', 'Other', 'Alex Johnson', 'A_NEGATIVE');

INSERT INTO [hospitalDB].[dbo].[doctor] ([email], [name], [specialization])
VALUES
('arjun.sharma@example.com', 'Dr. Arjun Sharma', 'Cardiology'),
('priya.iyer@example.com', 'Dr. Priya Iyer', 'Neurology'),
('rahul.verma@example.com', 'Dr. Rahul Verma', 'Orthopedics');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
('2025-07-01 10:30:00', 'General Checkup', 1, 2),
('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
('2025-07-05 16:15:00', 'Consultation', 1, 4),
('2025-07-06 08:30:00', 'Allergy Treatment', 2, 5);
CREATE TABLE covid_hospitals (
                                 hospital_id INT PRIMARY KEY,
                                 hospital_name VARCHAR(100) NOT NULL,
                                 location VARCHAR(100) NOT NULL,
                                 available_beds INT,
                                 medical_staff INT,
                                 ventilators INT,
                                 isolation_units INT
);

INSERT INTO covid_hospitals (hospital_id, hospital_name, location, available_beds, medical_staff, ventilators, isolation_units)
VALUES
    (1, '城市医院', '城市A', 150, 80, 20, 10),
    (2, '郊区医疗中心', '郊区B', 100, 50, 15, 8),
    (3, '山区综合医院', '山区C', 80, 40, 12, 6),
    (4, '新城区急救中心', '新城区D', 120, 60, 18, 12),
    (5, '县级医疗机构', '县城E', 90, 45, 14, 7),
    (6, '大学附属医院', '大学城F', 200, 100, 25, 15),
    (7, '港口医疗站', '港口G', 80, 35, 10, 5),
    (8, '工业园区医院', '工业园区H', 110, 55, 17, 9),
    (9, '农村诊所', '农村I', 60, 30, 8, 4),
    (10, '卫生服务站', '卫生服务站J', 70, 35, 9, 5);

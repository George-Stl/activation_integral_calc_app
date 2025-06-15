CREATE TABLE elements (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    cross_section JSON NOT NULL,
    gamma_lines JSON NOT NULL,
    half_life INT NOT NULL,
    mass_absorp_coeff JSON NOT NULL,
    density DOUBLE NOT NULL,
    molar_mass DOUBLE NOT NULL,
    isotope_concentration DOUBLE NOT NULL,
    num_of_gamma_on_one_decay SMALLINT NOT NULL
);

INSERT INTO elements VALUES (
    1, 'ALUMINIUM',
    '{"100" : 0.5, "200" : 0.7}',
    '[1.368, 2.754]', 53852,
    '[0.07, 0.045]', 2.7,
    26.98, 1, 2
);
/*TODO ЗАПОЛНИТЬ ПРАВИЛЬНЫЕ ЗНАЧЕНИЯ ДЛЯ INDIUM И FLUOROPLAST*/
INSERT INTO elements VALUES (
    2, 'INDIUM',
    '{"100" : 0.5, "200" : 0.7}',
    '[1.368, 2.754]', 53852,
    '[0.07, 0.045]', 2.7,
    26.98, 1, 2
);

INSERT INTO elements VALUES (
    3, 'FLUOROPLAST',
    '{"100" : 0.5, "200" : 0.7}',
    '[1.368, 2.754]', 53852,
    '[0.07, 0.045]', 2.7,
    26.98, 1, 2
);
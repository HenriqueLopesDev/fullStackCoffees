CREATE TABLE categories
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name       text NOT NULL,
    created_at date NOT NULL
);

insert into categories
values (gen_random_uuid(), 'Brazilian Coffee', '2021-01-01');

insert into categories
values (gen_random_uuid(), 'Colombian Coffee', '2021-01-01');

insert into categories
values (gen_random_uuid(), 'Ethiopian Coffee', '2021-01-01');

insert into categories
values (gen_random_uuid(), 'Guatemalan Coffee', '2021-01-01');

insert into categories
values (gen_random_uuid(), 'Honduran Coffee', '2021-01-01');

CREATE TABLE coffees
(
    id          uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name        text  NOT NULL,
    description text  NOT NULL,
    price       float NOT NULL,
    created_at  date  NOT NULL,
    category_id uuid  NOT NULL REFERENCES categories (id)
);

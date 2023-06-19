insert into user_account (user_id, user_password, `roles`, email, user_name, memo, created_at, modified_at)
            value ('admin', '{noop}1234', 'ROLE_ADMIN', 'admin@email.com', '어드민', '어드민 메모입니다.', now(), now());
insert into user_account (user_id, user_password, roles, email, user_name, memo, created_at, modified_at)
            value ('superadmin', '{noop}1234', 'ROLE_SUPERADMIN', 'superadmin@email.com', '슈퍼어드민', '슈퍼어드민 메모입니다.', now(), now());
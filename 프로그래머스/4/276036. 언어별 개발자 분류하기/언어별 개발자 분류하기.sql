-- 코드를 작성해주세요
SELECT *
FROM (
    SELECT
        CASE 
            -- A
            WHEN
                -- FE
                EXISTS (

                    SELECT 1
                    FROM   SKILLCODES S
                    WHERE  S.CATEGORY = 'Front End'
                        AND S.CODE & D.SKILL_CODE > 0

                -- PYTHON
                ) AND EXISTS (

                    SELECT 1
                    FROM   SKILLCODES S
                    WHERE  S.NAME = 'Python'
                        AND S.CODE & D.SKILL_CODE > 0

                ) THEN 'A'

            -- B
            WHEN
                EXISTS (

                    SELECT 1
                    FROM   SKILLCODES S
                    WHERE  S.NAME = 'C#'
                        AND S.CODE & D.SKILL_CODE > 0

                ) THEN 'B'

            -- C
            WHEN
                EXISTS (

                    SELECT 1
                    FROM   SKILLCODES S
                    WHERE  S.CATEGORY = 'Front End'
                        AND S.CODE & D.SKILL_CODE > 0

                ) THEN 'C'
            ELSE NULL
        END AS GRADE
        , D.ID
        , D.EMAIL
    FROM  DEVELOPERS D
) T
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID;
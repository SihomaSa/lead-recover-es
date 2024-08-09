CREATE PROCEDURE `get_offers`(IN pageNumber INT, IN pageSize INT)
BEGIN
DECLARE theOffset INT;
SET theOffset = (pageSize * pageNumber) - pageSize;
SELECT c1.id,
       c1.amount,
       c1.campaign_id,
       c1.channel,
       c1.created_at,
       c1.description,
       c1.expiration_date,
       c1.interest_rate,
       c1.segment,
       c1.source,
       c1.start_date,
       c1.status,
       c1.terms,
       c1.updated_at
FROM offer_projections c1
         JOIN (SELECT c2.id
               FROM offer_projections c2
               ORDER BY c2.created_at
                   LIMIT pageSize OFFSET theOffset) AS c3 ON c1.id = c3.id;
END
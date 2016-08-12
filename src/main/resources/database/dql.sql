select shelf.country,
       shelf.gold,
       shelf.silver,
       shelf.bronze,
       (shelf.gold + shelf.silver + shelf.bronze) as total
  from medalshelf shelf
 where event='london2012'
 order by shelf.gold desc,
          shelf.silver desc,
          shelf.bronze desc,
          shelf.country asc;

select shelf.country,
       shelf.gold,
       shelf.silver,
       shelf.bronze,
       (shelf.gold + shelf.silver + shelf.bronze) as total
  from medalshelf shelf
 where event='rio2016-09-Aug-2016'
 order by shelf.gold desc,
          shelf.silver desc,
          shelf.bronze desc,
          shelf.country asc;
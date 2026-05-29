-- 코드를 작성해주세요
select count(*)  as FISH_COUNT
from fish_info as fi
join fish_name_info as fn on fi.fish_type = fn.fish_type 
where fn.fish_name = 'BASS' or fn.fish_name = 'SNAPPER'
;
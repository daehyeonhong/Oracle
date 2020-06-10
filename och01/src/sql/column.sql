select 'private'||
			decode(data_type, 'NUMBER','int','VARCHAR2','String','DATE','Date',data_type)
			||' '||
			lower(column_name)
			column_name from cols where table_name = 'BOARD'
			order by column_id;
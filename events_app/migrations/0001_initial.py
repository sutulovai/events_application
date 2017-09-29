# -*- coding: utf-8 -*-
# Generated by Django 1.11.5 on 2017-09-29 12:56
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='CheckPoint',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=255)),
                ('latitude', models.FloatField()),
                ('longitude', models.FloatField()),
                ('description', models.CharField(max_length=4000, null=True)),
            ],
        ),
        migrations.CreateModel(
            name='Event',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('type', models.CharField(max_length=255)),
                ('name', models.CharField(max_length=255)),
                ('date_start', models.DateTimeField(null=True)),
                ('date_end', models.DateTimeField(null=True)),
                ('is_protected_event', models.BooleanField()),
                ('qr_enable', models.BooleanField()),
                ('description', models.CharField(max_length=4000, null=True)),
                ('created_at', models.DateTimeField(auto_now_add=True, null=True)),
                ('updated_at', models.DateTimeField(auto_now=True, null=True)),
            ],
        ),
        migrations.CreateModel(
            name='Location',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('latitude', models.FloatField()),
                ('longitude', models.FloatField()),
                ('event', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.Event')),
            ],
        ),
        migrations.CreateModel(
            name='Participant',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('event', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.Event')),
            ],
        ),
        migrations.CreateModel(
            name='PassedCheckpoints',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('total_time', models.IntegerField()),
                ('is_questionably', models.BooleanField()),
                ('description', models.CharField(max_length=4000, null=True)),
                ('checkpoint', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.CheckPoint')),
                ('participant', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.Participant')),
            ],
        ),
        migrations.CreateModel(
            name='TimeSlices',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('time_count', models.IntegerField()),
                ('checkpoint_from', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='checkpoint_from', to='events_app.CheckPoint')),
                ('checkpoint_to', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='checkpoint_to', to='events_app.CheckPoint')),
                ('event', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.Event')),
            ],
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=255)),
                ('email', models.EmailField(max_length=254, null=True)),
                ('age', models.IntegerField(null=True)),
                ('login', models.CharField(max_length=100)),
                ('is_admin', models.BooleanField()),
                ('created_at', models.DateTimeField(auto_now_add=True, null=True)),
                ('updated_at', models.DateTimeField(auto_now=True, null=True)),
            ],
        ),
        migrations.AddField(
            model_name='participant',
            name='user',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.User'),
        ),
        migrations.AddField(
            model_name='location',
            name='participant',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.Participant'),
        ),
        migrations.AddField(
            model_name='event',
            name='user',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.User'),
        ),
        migrations.AddField(
            model_name='checkpoint',
            name='event',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='events_app.Event'),
        ),
    ]